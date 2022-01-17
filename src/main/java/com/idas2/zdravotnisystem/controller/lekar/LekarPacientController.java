package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import com.idas2.zdravotnisystem.db.entity.ZdravortniKarta;
import com.idas2.zdravotnisystem.db.repository.*;
import com.idas2.zdravotnisystem.db.repository.impl.NemocnicniPokojRepositoryImpl;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.*;
import com.idas2.zdravotnisystem.service.form.LekarPacientFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/lekar/pacient")
public class LekarPacientController {

    private final ObrazekRepository obrazekRepository;
    private final PacientRepository pacientRepository;
    private final PojisteniRepository pojisteniRepository;
    private final PojistovnaRepository pojistovnaRepository;
    private final LekarPacientFormService lekarPacientFormService;
    private final ZdravotniKartaRepository zdravotniKartaRepository;
    private final NemocnicniPokojRepositoryImpl nemocnicniPokojRepository;

    @Autowired
    public LekarPacientController(
        ObrazekRepository obrazekRepository,
        PacientRepository pacientRepository,
        PojisteniRepository pojisteniRepository,
        PojistovnaRepository pojistovnaRepository,
        LekarPacientFormService lekarPacientFormService,
        ZdravotniKartaRepository zdravotniKartaRepository,
        NemocnicniPokojRepositoryImpl nemocnicniPokojRepository
    ) {
        this.obrazekRepository = obrazekRepository;
        this.pacientRepository = pacientRepository;
        this.pojisteniRepository = pojisteniRepository;
        this.pojistovnaRepository = pojistovnaRepository;
        this.lekarPacientFormService = lekarPacientFormService;
        this.zdravotniKartaRepository = zdravotniKartaRepository;
        this.nemocnicniPokojRepository = nemocnicniPokojRepository;
    }

    @GetMapping("/list")
    public ModelAndView list(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<PacientView> list = pacientRepository.findAllView();
        return new ModelAndView("lekar/pacient/list")
            .addObject("list", list)
            .addObject("authUser", authUser);
    }

    @GetMapping("/delete")
    public ModelAndView delete(
        @RequestParam Integer pacId
    ){
        pacientRepository.delete(pacId);
        return RedirectUtil.redirect("/lekar/pacient/list");
    }

    @GetMapping("/{pacientUuid}/edit")
    public ModelAndView edit(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser
    ) {

        PacientView pacientView =
            pacientRepository.getPacientViewByUzivatelUuid(pacientUuid);

        LekarPacientUpdateForm pacientForm =
            lekarPacientFormService.buildPacientForm(pacientView, new LekarPacientUpdateForm());

        ZdravortniKarta zdravortniKarta =
            zdravotniKartaRepository.findByPacientId(pacientView.getId());

        List<Pojistovna> pojistovnaList = pojistovnaRepository.findAll();

        Pojisteni pojisteni =
            pojisteniRepository.findByZdravorniKartaId(zdravortniKarta.getId());

        LekarKartaUpdateForm kartaForm =
            lekarPacientFormService.buildKartaForm(zdravortniKarta, new LekarKartaUpdateForm());

        LekarPojisteniForm pojisteniForm =
            lekarPacientFormService.buildPojisteniForm(pojisteni, new LekarPojisteniForm());

        String avatar = null;

        if (Objects.nonNull(pacientView.getObrazekData())) {
            byte[] imgBytesAsBase64 = Base64.encodeBase64(pacientView.getObrazekData());
            String imgDataAsBase64 = new String(imgBytesAsBase64);
            avatar = String.format(
                "data:image/%s;base64,%s",
                pacientView.getObrazekPripona(), imgDataAsBase64
            );
        }

        return new ModelAndView("lekar/pacient/info")
            .addObject("avatar", avatar)
            .addObject("authUser", authUser)
            .addObject("kartaForm", kartaForm)
            .addObject("pojisteni", pojisteni)
            .addObject("pacientForm", pacientForm)
            .addObject("pacientView", pacientView)
            .addObject("pojisteniForm", pojisteniForm)
            .addObject("pojistovnaList", pojistovnaList)
            .addObject("zdravotniKarta", zdravortniKarta)
            .addObject("pokojList", nemocnicniPokojRepository.findAll());
    }

    @PostMapping("/{pacientUuid}/profile/update")
    public ModelAndView updateProfile(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("pacientForm") LekarPacientUpdateForm pacientForm
    ) {
        PacientView pacientView =
            pacientRepository.getPacientViewByUzivatelUuid(pacientUuid);

        lekarPacientFormService.updatePacientForm(pacientView.getId(), pacientForm);

        pacientView =
            pacientRepository.getPacientViewByUzivatelId(pacientView.getId());

        return RedirectUtil.redirect(String.format("/lekar/pacient/%s/edit", pacientView.getUuid()));
    }

    @PostMapping("/{pacientUuid}/karta/update")
    public ModelAndView updateKarta(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("kartaForm") LekarKartaUpdateForm kartaForm
    ) {
        PacientView pacientView =
            pacientRepository.getPacientViewByUzivatelUuid(pacientUuid);

        lekarPacientFormService.updateKartaForm(pacientView.getId(), kartaForm);

        return RedirectUtil.redirect(String.format("/lekar/pacient/%s/edit", pacientUuid));
    }

    @PostMapping("/{pacientUuid}/pojisteni/update")
    public ModelAndView updatePojisteni(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("pojisteniForm") LekarPojisteniForm pojisteniForm
    ) {
        PacientView pacientView =
            pacientRepository.getPacientViewByUzivatelUuid(pacientUuid);

        ZdravortniKarta zdravortniKarta =
            zdravotniKartaRepository.findByPacientId(pacientView.getId());

        pojisteniForm.setZdravotniKartaIdKarta(zdravortniKarta.getId());

        lekarPacientFormService.updatePojisteniForm(zdravortniKarta.getId(), pojisteniForm);
        return RedirectUtil.redirect(String.format("/lekar/pacient/%s/edit", pacientUuid));
    }

    @PostMapping("/{pacientUuid}/avatar/update")
    public ModelAndView updateAvatar(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser,
        @RequestParam("obrazek") MultipartFile file
    ) {
        PacientView pacientView =
            pacientRepository.getPacientViewByUzivatelUuid(pacientUuid);

        obrazekRepository.upload(pacientView, file);

        return RedirectUtil.redirect(
            String.format("/lekar/pacient/%s/edit", pacientUuid));
    }

}
