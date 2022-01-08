package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.HospitalizaceRepository;
import com.idas2.zdravotnisystem.db.repository.ProceduraRepository;
import com.idas2.zdravotnisystem.db.repository.TypProceduryRepository;
import com.idas2.zdravotnisystem.db.repository.TypZarizeniRepository;
import com.idas2.zdravotnisystem.db.view.ProceduraView;
import com.idas2.zdravotnisystem.form.ProceduraCreateForm;
import com.idas2.zdravotnisystem.service.form.ProceduraFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/lekar/procedura")
public class LekarProceduraController {

    private final ProceduraRepository proceduraRepository;
    private final ProceduraFormService proceduraFormService;
    private final TypZarizeniRepository typZarizeniRepository;
    private final TypProceduryRepository typProceduryRepository;
    private final HospitalizaceRepository hospitalizaceRepository;

    @Autowired
    public LekarProceduraController(
        ProceduraRepository proceduraRepository,
        ProceduraFormService proceduraFormService,
        TypZarizeniRepository typZarizeniRepository,
        TypProceduryRepository typProceduryRepository,
        HospitalizaceRepository hospitalizaceRepository
    ) {
        this.proceduraRepository = proceduraRepository;
        this.proceduraFormService = proceduraFormService;
        this.typZarizeniRepository = typZarizeniRepository;
        this.typProceduryRepository = typProceduryRepository;
        this.hospitalizaceRepository = hospitalizaceRepository;
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
            .addObject("list", list);
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
            .addObject("list", list);
    }

    @GetMapping("/add")
    public ModelAndView add(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView("lekar/appointment/create")
            .addObject("form", new ProceduraCreateForm())
            .addObject("typProceduryList", typProceduryRepository.findAll())
            .addObject("typZarizeniList", typZarizeniRepository.findAll())
            .addObject("hospitalizaceList", hospitalizaceRepository.findAll());
    }

    @PostMapping("/create")
    public ModelAndView create(
        @ModelAttribute("form") ProceduraCreateForm form
    ) {
        proceduraFormService.create(form);
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
