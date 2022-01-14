package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import com.idas2.zdravotnisystem.db.entity.ZdravortniKarta;
import com.idas2.zdravotnisystem.db.repository.PacientRepository;
import com.idas2.zdravotnisystem.db.repository.PojisteniRepository;
import com.idas2.zdravotnisystem.db.repository.PojistovnaRepository;
import com.idas2.zdravotnisystem.db.repository.ZdravotniKartaRepository;
import com.idas2.zdravotnisystem.db.repository.impl.NemocnicniPokojRepositoryImpl;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.lekar.*;
import com.idas2.zdravotnisystem.service.form.PacientFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/lekar/pacient")
public class LekarPacientController {

    private final PacientRepository pacientRepository;
    private final PacientFormService pacientFormService;
    private final PojisteniRepository pojisteniRepository;
    private final PojistovnaRepository pojistovnaRepository;
    private final ZdravotniKartaRepository zdravotniKartaRepository;
    private final NemocnicniPokojRepositoryImpl nemocnicniPokojRepository;

    @Autowired
    public LekarPacientController(
        PacientRepository pacientRepository,
        PacientFormService pacientFormService,
        PojisteniRepository pojisteniRepository,
        PojistovnaRepository pojistovnaRepository,
        ZdravotniKartaRepository zdravotniKartaRepository,
        NemocnicniPokojRepositoryImpl nemocnicniPokojRepository
    ) {
        this.pacientRepository = pacientRepository;
        this.pacientFormService = pacientFormService;
        this.pojisteniRepository = pojisteniRepository;
        this.pojistovnaRepository = pojistovnaRepository;
        this.zdravotniKartaRepository = zdravotniKartaRepository;
        this.nemocnicniPokojRepository = nemocnicniPokojRepository;
    }

    @GetMapping("/list")
    public ModelAndView list(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<PacientView> list = pacientRepository.findAllView();
        return new ModelAndView("lekar/pacient/list")
            .addObject("list", list);
    }


//    @PostMapping("/{pacientUuid}/add")
//    public ModelAndView add(
//        @PathVariable String pacientUuid,
//        @AuthenticationPrincipal AuthUser authUser
//    ){
//        return new ModelAndView();
//    }
//

    @GetMapping("/{pacientUuid}/edit")
    public ModelAndView edit(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        LerkarPacientUpdateForm pacientForm =
            new LerkarPacientUpdateForm();

        LekarKartaUpdateForm kartaForm = new LekarKartaUpdateForm();
        PacientView pacientView =
            pacientRepository.getPacientViewByUzivatelUuid(pacientUuid);


        ZdravortniKarta zdravortniKarta =
            zdravotniKartaRepository.findByPacientId(pacientView.getId());

        List<Pojistovna> pojistovnaList = pojistovnaRepository.findAll();

        Pojisteni pojisteni =
            pojisteniRepository.findByZdravorniKartaId(zdravortniKarta.getId());

        LekarPojisteniForm pojisteniForm = new LekarPojisteniForm();

        LekarZdravortniKartaForm zdravortniKartaForm = new LekarZdravortniKartaForm();

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
            .addObject("pacientForm", pacientForm)
            .addObject("pacientView", pacientView)
            .addObject("pojistovnaList", pojistovnaList)
            .addObject("zdravotniKarta", zdravortniKarta)
            .addObject("zdravotniKartaForm", zdravortniKarta)
            .addObject("pojisteni", pojisteni)
            .addObject("pojisteniForm", pojisteniForm)
            .addObject("avatar", avatar)
            .addObject("pokojList", nemocnicniPokojRepository.findAll())
            .addObject("kartaForm", kartaForm);
    }

    @PostMapping("/{pacientUuid}/profile/update")
    public ModelAndView updateProfile(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("pacientForm") LekarProfileUpdateForm pacientForm
    ) {
//        pacientFormService.updateProfileInfo(pacientUuid, pacientForm);

        return RedirectUtil.redirect(String.format("/lekar/pacient/%s/edit"), pacientUuid);
    }

    @PostMapping("/{pacientUuid}/karta/update")
    public ModelAndView updateKarta(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser
//        @ModelAttribute("zdravotniKartaName") LekarProfileUpdateForm pacientForm,
        ) {
//        pacientFormService.updateProfileInfo(pacientUuid, pacientForm);

        return RedirectUtil.redirect(String.format("/lekar/pacient/%s/edit"), pacientUuid);
    }

    @PostMapping("/{pacientUuid}/pojisteni/update")
    public ModelAndView updatePojisteni(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser
//        @ModelAttribute("zdravotniKartaName") LekarProfileUpdateForm pacientForm,
    ) {
//        pacientFormService.updateProfileInfo(pacientUuid, pacientForm);

        return RedirectUtil.redirect(String.format("/lekar/pacient/%s/edit"), pacientUuid);
    }
}
