package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.TypProcedury;
import com.idas2.zdravotnisystem.db.entity.Zarizeni;
import com.idas2.zdravotnisystem.db.repository.*;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import com.idas2.zdravotnisystem.db.view.LekarView;
import com.idas2.zdravotnisystem.db.view.ProceduraView;
import com.idas2.zdravotnisystem.form.procedura.ProceduraCreateForm;
import com.idas2.zdravotnisystem.form.procedura.ProceduraUpdateForm;
import com.idas2.zdravotnisystem.service.form.ProceduraFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/procedura")
public class AdminProceduraController {

    private final LekarRepository lekarRepository;
    private final ZarizeniRepository zarizeniRepository;
    private final ProceduraRepository proceduraRepository;
    private final ProceduraFormService proceduraFormService;
    private final TypProceduryRepository typProceduryRepository;
    private final HospitalizaceRepository hospitalizaceRepository;

    @Autowired
    public AdminProceduraController(
        LekarRepository lekarRepository,
        ZarizeniRepository zarizeniRepository,
        ProceduraRepository proceduraRepository,
        ProceduraFormService proceduraFormService,
        TypProceduryRepository typProceduryRepository,
        HospitalizaceRepository hospitalizaceRepository
    ) {
        this.lekarRepository = lekarRepository;
        this.typProceduryRepository = typProceduryRepository;
        this.hospitalizaceRepository = hospitalizaceRepository;
        this.zarizeniRepository = zarizeniRepository;
        this.proceduraRepository = proceduraRepository;
        this.proceduraFormService = proceduraFormService;
    }

    @GetMapping("")
    public ModelAndView list(
    ) {
        List<ProceduraView> list = proceduraRepository.findAll();

        return new ModelAndView("admin/overview/procedura/list")
            .addObject("list", list);
    }

    @GetMapping("/create")
    public ModelAndView create(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<LekarView> lekarList = lekarRepository.findAllView();
        List<Zarizeni> zarizeniList = zarizeniRepository.findAll();
        List<TypProcedury> typProceduryList = typProceduryRepository.findAll();
        List<HospitalizaceView> hospitalizaceList = hospitalizaceRepository.findAll();

        return new ModelAndView("admin/overview/procedura/create")
            .addObject("authUser", authUser)
            .addObject("lekarList", lekarList)
            .addObject("zarizeniList", zarizeniList)
            .addObject("form", new ProceduraCreateForm())
            .addObject("typProceduryList", typProceduryList)
            .addObject("hospitalizaceList", hospitalizaceList);
    }

    @PostMapping("/save")
    public ModelAndView save(
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("form") ProceduraCreateForm form
    ) {
        proceduraFormService.createAdmin(form);
        return RedirectUtil.redirect("/admin/procedura");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        ProceduraView view =
            proceduraRepository.findOne(id);

        List<LekarView> lekarList = lekarRepository.findAllView();
        List<Zarizeni> zarizeniList = zarizeniRepository.findAll();
        List<TypProcedury> typProceduryList = typProceduryRepository.findAll();
        List<HospitalizaceView> hospitalizaceList = hospitalizaceRepository.findAll();


        return new ModelAndView("/admin/overview/procedura/edit")
            .addObject("id", id)
            .addObject("authUser", authUser)
            .addObject("lekarList", lekarList)
            .addObject("zarizeniList", zarizeniList)
            .addObject("typProceduryList", typProceduryList)
            .addObject("hospitalizaceList", hospitalizaceList)
            .addObject("form", proceduraFormService.buildUpdateForm(view));
    }

    @PostMapping("/{id}/update")
    public ModelAndView update(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("form") ProceduraUpdateForm form
    ) {
        form.setId(id);
        proceduraFormService.update(form);
        return RedirectUtil.redirect("/admin/procedura");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        proceduraRepository.delete(id);
        return RedirectUtil.redirect("/admin/procedura");
    }
}
