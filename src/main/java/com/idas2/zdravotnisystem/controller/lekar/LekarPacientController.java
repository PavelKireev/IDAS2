package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import com.idas2.zdravotnisystem.db.entity.ZdravortniKarta;
import com.idas2.zdravotnisystem.db.repository.PacientRepository;
import com.idas2.zdravotnisystem.db.repository.PojisteniRepository;
import com.idas2.zdravotnisystem.db.repository.PojistovnaRepository;
import com.idas2.zdravotnisystem.db.repository.ZdravotniKartaRepository;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.lekar.LekarPojisteniForm;
import com.idas2.zdravotnisystem.form.lekar.LekarProfileUpdateForm;
import com.idas2.zdravotnisystem.form.lekar.LekarZdravortniKartaForm;
import com.idas2.zdravotnisystem.form.lekar.LerkarPacientUpdateForm;
import com.idas2.zdravotnisystem.service.form.PacientFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/lekar/pacient")
public class LekarPacientController {

    private final PacientRepository pacientRepository;
    private final PacientFormService pacientFormService;
    private final PojisteniRepository pojisteniRepository;
    private final PojistovnaRepository pojistovnaRepository;
    private final ZdravotniKartaRepository zdravotniKartaRepository;

    @Autowired
    public LekarPacientController(
        PacientRepository pacientRepository,
        PacientFormService pacientFormService,
        PojisteniRepository pojisteniRepository,
        PojistovnaRepository pojistovnaRepository,
        ZdravotniKartaRepository zdravotniKartaRepository
    ) {
        this.pacientRepository = pacientRepository;
        this.pacientFormService = pacientFormService;
        this.pojisteniRepository = pojisteniRepository;
        this.pojistovnaRepository = pojistovnaRepository;
        this.zdravotniKartaRepository = zdravotniKartaRepository;
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
        PacientView pacientView =
            pacientRepository.getPacientViewByUzivatelUuid(pacientUuid);


        ZdravortniKarta zdravortniKarta =
            zdravotniKartaRepository.findByPacientUuid(pacientUuid);

        List<Pojistovna> pojistovnaList = pojistovnaRepository.findAll();

        Pojisteni pojisteni =
            pojisteniRepository.findByZdravorniKartaId(zdravortniKarta.getId());

        LekarPojisteniForm pojisteniForm = new LekarPojisteniForm();

        LekarZdravortniKartaForm zdravortniKartaForm = new LekarZdravortniKartaForm();

        return new ModelAndView("lekar/pacient/edit")
            .addObject("pacientForm", pacientForm)
            .addObject("pacientView", pacientView)
            .addObject("pojistovnaList", pojistovnaList)
            .addObject("zdravotniKarta", zdravortniKarta)
            .addObject("zdravotniKartaForm", zdravortniKarta)
            .addObject("pojisteni", pojisteni)
            .addObject("pojisteniForm", pojisteniForm);
    }

    @PostMapping("/{pacientUuid}/update")
    public ModelAndView update(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("pacientForm") LekarProfileUpdateForm pacientForm,
        @ModelAttribute("zdravotniKartaForm") LekarZdravortniKartaForm lekarZdravortniKartaForm,
        @ModelAttribute("pojisteniForm") LekarPojisteniForm lekarPojisteniForm
    ) {
//        pacientFormService.updateProfileInfo(pacientUuid, pacientForm);

        return RedirectUtil.redirect(String.format("/lekar/pacient/%s/edit"), pacientUuid);
    }
}
