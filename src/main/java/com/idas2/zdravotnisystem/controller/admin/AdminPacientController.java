package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.entity.ZdravotniKarta;
import com.idas2.zdravotnisystem.db.repository.*;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarKartaUpdateForm;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarPojisteniForm;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.PacientUpdateForm;
import com.idas2.zdravotnisystem.form.uzivatel.pacient.PacientSignUpForm;
import com.idas2.zdravotnisystem.service.form.LekarPacientFormService;
import com.idas2.zdravotnisystem.service.form.PacientFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.uzivatel.pacient.PacientCreateFormValidator;
import com.idas2.zdravotnisystem.validator.uzivatel.pacient.PacientUpdateFormValidator;
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
@RequestMapping("/admin/uzivatel/pacient")
public class AdminPacientController {

    private final PacientRepository repository;
    private final ObrazekRepository obrazekRepository;
    private final UzivatelRepository uzivatelRepository;
    private final PacientFormService pacientFormService;
    private final PojisteniRepository pojisteniRepository;
    private final PojistovnaRepository pojistovnaRepository;
    private final LekarPacientFormService lekarPacientFormService;
    private final ZdravotniKartaRepository zdravotniKartaRepository;
    private final NemocnicniPokojRepository nemocnicniPokojRepository;
    private final PacientCreateFormValidator pacientCreateFormValidator;
    private final PacientUpdateFormValidator pacientUpdateFormValidator;

    @Autowired
    public AdminPacientController(
        PacientRepository repository,
        ObrazekRepository obrazekRepository,
        UzivatelRepository uzivatelRepository,
        PacientFormService pacientFormService,
        PojisteniRepository pojisteniRepository,
        PojistovnaRepository pojistovnaRepository,
        LekarPacientFormService lekarPacientFormService,
        ZdravotniKartaRepository zdravotniKartaRepository,
        NemocnicniPokojRepository nemocnicniPokojRepository,
        PacientCreateFormValidator pacientCreateFormValidator,
        PacientUpdateFormValidator pacientUpdateFormValidator
    ) {
        this.repository = repository;
        this.obrazekRepository = obrazekRepository;
        this.uzivatelRepository = uzivatelRepository;
        this.pacientFormService = pacientFormService;
        this.pojisteniRepository = pojisteniRepository;
        this.pojistovnaRepository = pojistovnaRepository;
        this.lekarPacientFormService = lekarPacientFormService;
        this.zdravotniKartaRepository = zdravotniKartaRepository;
        this.nemocnicniPokojRepository = nemocnicniPokojRepository;
        this.pacientCreateFormValidator = pacientCreateFormValidator;
        this.pacientUpdateFormValidator = pacientUpdateFormValidator;
    }

    @GetMapping("")
    public ModelAndView info(
    ) {
        List<PacientView> list = repository.findAllView();
        return new ModelAndView("/admin/overview/pacient/list")
            .addObject("list", list);
    }

    @GetMapping("/create")
    public ModelAndView create(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView("/admin/overview/pacient/create")
            .addObject("authUser", authUser)
            .addObject("form", new PacientSignUpForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("form") PacientSignUpForm form
    ) {
        pacientFormService.signUp(form);
        return RedirectUtil.redirect("/admin/uzivatel/pacient");
    }

    @GetMapping("/delete")
    public ModelAndView delete(
        @RequestParam Integer pacId
    ) {
        repository.delete(pacId);
        return RedirectUtil.redirect("/admin/uzivatel/pacient");
    }

    @GetMapping("/{pacientUuid}/edit")
    public ModelAndView edit(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser
    ) {

        PacientView pacientView =
            repository.getPacientViewByUzivatelUuid(pacientUuid);

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

        return new ModelAndView("admin/overview/pacient/edit")
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
        @ModelAttribute("pacientForm") PacientUpdateForm pacientForm
    ) {
        PacientView pacientView =
            repository.getPacientViewByUzivatelUuid(pacientUuid);

        lekarPacientFormService.updatePacientForm(pacientView.getId(), pacientForm);

        pacientView =
            repository.getPacientViewByUzivatelId(pacientView.getId());

        return RedirectUtil.redirect(String.format("/admin/uzivatel/pacient/%s/edit", pacientView.getUuid()));
    }

    @PostMapping("/{pacientUuid}/karta/update")
    public ModelAndView updateKarta(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("kartaForm") LekarKartaUpdateForm kartaForm
    ) {
        PacientView pacientView =
            repository.getPacientViewByUzivatelUuid(pacientUuid);

        lekarPacientFormService.updateKartaForm(pacientView.getId(), kartaForm);

        return RedirectUtil.redirect(String.format("/admin/uzivatel/pacient/%s/edit", pacientView.getUuid()));
    }

    @PostMapping("/{pacientUuid}/pojisteni/update")
    public ModelAndView updatePojisteni(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("pojisteniForm") LekarPojisteniForm pojisteniForm
    ) {
        PacientView pacientView =
            repository.getPacientViewByUzivatelUuid(pacientUuid);

        ZdravotniKarta zdravotniKarta =
            zdravotniKartaRepository.findByPacientId(pacientView.getId());

        pojisteniForm.setZdravotniKartaIdKarta(zdravotniKarta.getId());

        lekarPacientFormService.updatePojisteniForm(zdravotniKarta.getId(), pojisteniForm);
        return RedirectUtil.redirect(String.format("/admin/uzivatel/pacient/%s/edit", pacientView.getUuid()));
    }

    @PostMapping("/{pacientUuid}/avatar/update")
    public ModelAndView updateAvatar(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser,
        @RequestParam("obrazek") MultipartFile file
    ) {
        PacientView pacientView =
            repository.getPacientViewByUzivatelUuid(pacientUuid);

        obrazekRepository.upload(pacientView, file);

        return RedirectUtil.redirect(String.format("/admin/uzivatel/pacient/%s/edit", pacientView.getUuid()));

    }

    @GetMapping("/{pacientId}/simulate")
    public ModelAndView simulate(
        @PathVariable Integer pacientId,
        @AuthenticationPrincipal AuthUser authUser
    ) {

        User user = uzivatelRepository.findById(pacientId);
        authUser.setAdminId(authUser.getUser().getId());
        authUser.setSimulated(true);
        authUser.setUser(user);

        return RedirectUtil.redirect("/pacient/profile/info");
    }

    @GetMapping("/unsimulate")
    public ModelAndView unsimulate(
        @RequestParam Integer admId,
        @AuthenticationPrincipal AuthUser authUser
    ) {

        User user = uzivatelRepository.findById(admId);

        authUser.setAdminId(0);
        authUser.setSimulated(false);
        authUser.setUser(user);

        return RedirectUtil.redirect("/admin/uzivatel/pacient");
    }

    @GetMapping("/{pacientUuid}/zdravotni-karta")
    public ModelAndView pojisteniList(
        @PathVariable String pacientUuid
    ){
        PacientView view =
            repository.getPacientViewByUzivatelUuid(pacientUuid);

        ZdravotniKarta zdravotniKarta =
            zdravotniKartaRepository.findByPacientId(view.getId());



        pojisteniRepository.findByZdravorniKartaId(zdravotniKarta.getId());
        return new ModelAndView("");
    }

}
