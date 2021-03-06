package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import com.idas2.zdravotnisystem.db.entity.ZdravotniKarta;
import com.idas2.zdravotnisystem.db.repository.*;
import com.idas2.zdravotnisystem.db.repository.impl.NemocnicniPokojRepositoryImpl;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.*;
import com.idas2.zdravotnisystem.service.form.LekarPacientFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.uzivatel.lekar.LekarPojisteniFormValidator;
import com.idas2.zdravotnisystem.validator.uzivatel.lekar.LekarZdravotniKartaFormValidator;
import com.idas2.zdravotnisystem.validator.uzivatel.pacient.PacientUpdateFormValidator;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
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

    private final PacientUpdateFormValidator pacientUpdateFormValidator;
    private final LekarPojisteniFormValidator lekarPojisteniFormValidator;
    private final LekarZdravotniKartaFormValidator lekarZdravotniKartaFormValidator;

    @Autowired
    public LekarPacientController(
        ObrazekRepository obrazekRepository,
        PacientRepository pacientRepository,
        PojisteniRepository pojisteniRepository,
        PojistovnaRepository pojistovnaRepository,
        LekarPacientFormService lekarPacientFormService,
        ZdravotniKartaRepository zdravotniKartaRepository,
        NemocnicniPokojRepositoryImpl nemocnicniPokojRepository,
        PacientUpdateFormValidator pacientUpdateFormValidator,
        LekarPojisteniFormValidator lekarPojisteniFormValidator,
        LekarZdravotniKartaFormValidator lekarZdravotniKartaFormValidator
    ) {
        this.obrazekRepository = obrazekRepository;
        this.pacientRepository = pacientRepository;
        this.pojisteniRepository = pojisteniRepository;
        this.pojistovnaRepository = pojistovnaRepository;
        this.lekarPacientFormService = lekarPacientFormService;
        this.zdravotniKartaRepository = zdravotniKartaRepository;
        this.nemocnicniPokojRepository = nemocnicniPokojRepository;
        this.pacientUpdateFormValidator = pacientUpdateFormValidator;
        this.lekarPojisteniFormValidator = lekarPojisteniFormValidator;
        this.lekarZdravotniKartaFormValidator = lekarZdravotniKartaFormValidator;
    }

    @InitBinder("pacientUpdateForm")
    protected void initUpdateBinder(WebDataBinder binder) {
        binder.addValidators(pacientUpdateFormValidator);
    }

    @InitBinder("kartaUpdateForm")
    protected void initKartaUpdateBinder(WebDataBinder binder) {
        binder.addValidators(lekarZdravotniKartaFormValidator);
    }

    @InitBinder("pojisteniUpdateForm")
    protected void initPojisteniUpdateBinder(WebDataBinder binder) {
        binder.addValidators(lekarPojisteniFormValidator);
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

        PacientUpdateForm pacientForm =
            lekarPacientFormService.buildPacientForm(pacientView, new PacientUpdateForm());

        ZdravotniKarta zdravotniKarta =
            zdravotniKartaRepository.findByPacientId(pacientView.getId());

        List<Pojistovna> pojistovnaList = pojistovnaRepository.findAll();

        Pojisteni pojisteni =
            pojisteniRepository.findByZdravorniKartaId(zdravotniKarta.getId());

        LekarKartaUpdateForm kartaForm =
            lekarPacientFormService.buildKartaForm(zdravotniKarta, new LekarKartaUpdateForm());

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
            .addObject("zdravotniKarta", zdravotniKarta)
            .addObject("pokojList", nemocnicniPokojRepository.findAll());
    }

    @PostMapping("/{pacientUuid}/profile/update")
    public ModelAndView updateProfile(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("pacientUpdateForm") PacientUpdateForm pacientUpdateForm,
        BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){

            PacientView pacientView =
                pacientRepository.getPacientViewByUzivatelUuid(pacientUuid);

            PacientUpdateForm pacientForm =
                lekarPacientFormService.buildPacientForm(pacientView, new PacientUpdateForm());

            ZdravotniKarta zdravotniKarta =
                zdravotniKartaRepository.findByPacientId(pacientView.getId());

            List<Pojistovna> pojistovnaList = pojistovnaRepository.findAll();

            Pojisteni pojisteni =
                pojisteniRepository.findByZdravorniKartaId(zdravotniKarta.getId());

            LekarKartaUpdateForm kartaForm =
                lekarPacientFormService.buildKartaForm(zdravotniKarta, new LekarKartaUpdateForm());

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
                .addObject("pacientUpdateForm", pacientUpdateForm)
                .addObject("pacientView", pacientView)
                .addObject("pojisteniForm", pojisteniForm)
                .addObject("pojistovnaList", pojistovnaList)
                .addObject("zdravotniKarta", zdravotniKarta)
                .addObject("pokojList", nemocnicniPokojRepository.findAll());
        }
        PacientView pacientView =
            pacientRepository.getPacientViewByUzivatelUuid(pacientUuid);

        lekarPacientFormService.updatePacientForm(pacientView.getId(), pacientUpdateForm);

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

        ZdravotniKarta zdravotniKarta =
            zdravotniKartaRepository.findByPacientId(pacientView.getId());

        pojisteniForm.setZdravotniKartaIdKarta(zdravotniKarta.getId());

        lekarPacientFormService.updatePojisteniForm(zdravotniKarta.getId(), pojisteniForm);
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
