package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.*;
import com.idas2.zdravotnisystem.db.view.ProceduraView;
import com.idas2.zdravotnisystem.form.procedura.ProceduraCreateForm;
import com.idas2.zdravotnisystem.service.form.ProceduraFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.procedura.ProceduraCreateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/lekar/procedura")
public class LekarProceduraController {

    private final ProceduraRepository proceduraRepository;
    private final ProceduraFormService proceduraFormService;
    private final ZarizeniRepository zarizeniRepository;
    private final TypProceduryRepository typProceduryRepository;
    private final HospitalizaceRepository hospitalizaceRepository;

    private final ProceduraCreateFormValidator proceduraCreateFormValidator;


    @Autowired
    public LekarProceduraController(
        ProceduraRepository proceduraRepository,
        ProceduraFormService proceduraFormService,
        ZarizeniRepository zarizeniRepository,
        TypProceduryRepository typProceduryRepository,
        HospitalizaceRepository hospitalizaceRepository,
        ProceduraCreateFormValidator proceduraCreateFormValidator
    ) {
        this.proceduraRepository = proceduraRepository;
        this.proceduraFormService = proceduraFormService;
        this.zarizeniRepository = zarizeniRepository;
        this.typProceduryRepository = typProceduryRepository;
        this.hospitalizaceRepository = hospitalizaceRepository;
        this.proceduraCreateFormValidator = proceduraCreateFormValidator;
    }

    @InitBinder("createForm")
    protected void initKartaUpdateBinder(WebDataBinder binder) {
        binder.addValidators(proceduraCreateFormValidator);
    }

    @GetMapping("/nadchazejici")
    public ModelAndView nadchazejiciProcedury(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<ProceduraView> list =
            proceduraRepository
                .getProceduraViewListByLekarIdAfterNow(
                    authUser.getUser().getId()
                );

        return new ModelAndView("lekar/appointment/list")
            .addObject("list", list)
            .addObject("authUser", authUser);
    }

    @GetMapping("/minule")
    public ModelAndView minuleProcedury(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<ProceduraView> list =
            proceduraRepository
                .getProceduraViewListByLekarIdBeforeNow(
                    authUser.getUser().getId()
                );

        return new ModelAndView("lekar/appointment/list")
            .addObject("list", list)
            .addObject("authUser", authUser);
    }

    @GetMapping("/add")
    public ModelAndView add(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView("lekar/appointment/create")
            .addObject("authUser", authUser)
            .addObject("createForm", new ProceduraCreateForm())
            .addObject("typProceduryList", typProceduryRepository.findAll())
            .addObject("zarizeniList", zarizeniRepository.findAll())
            .addObject("hospitalizaceList", hospitalizaceRepository.findAll());
    }

    @PostMapping("/create")
    public ModelAndView create(
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("createForm") ProceduraCreateForm createForm,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("lekar/appointment/create")
                .addObject("authUser", authUser)
                .addObject("createForm", createForm)
                .addObject("typProceduryList", typProceduryRepository.findAll())
                .addObject("zarizeniList", zarizeniRepository.findAll())
                .addObject("hospitalizaceList", hospitalizaceRepository.findAll());
        }

        proceduraFormService.create(createForm);
        return RedirectUtil.redirect("/lekar/procedura/nadchazejici");
    }

    @GetMapping("/delete")
    public ModelAndView delete(
        @RequestParam("id") String uuid
    ) {
        proceduraRepository.deleteByUuid(uuid);
        return RedirectUtil.redirect("/lekar/procedura/nadchazejici");
    }

}
