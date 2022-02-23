package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.KancelarRepository;
import com.idas2.zdravotnisystem.db.view.KancelarView;
import com.idas2.zdravotnisystem.form.mistnost.kancelar.KancelarCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.kancelar.KancelarUpdateForm;
import com.idas2.zdravotnisystem.service.form.KancelarFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/mistnost/kancelar")
public class AdminKancelarController {

    private final KancelarRepository kancelarRepository;
    private final KancelarFormService kancelarFormService;

    @Autowired
    public AdminKancelarController(
        KancelarRepository kancelarRepository,
        KancelarFormService kancelarFormService
    ) {
        this.kancelarRepository = kancelarRepository;
        this.kancelarFormService = kancelarFormService;
    }

    @GetMapping("")
    public ModelAndView list(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<KancelarView> list = kancelarRepository.findAllView();

        return new ModelAndView("admin/overview/kancelar/list")
            .addObject("list", list)
            .addObject("authUser", authUser);
    }

    @GetMapping("/create")
    public ModelAndView create(
        @AuthenticationPrincipal AuthUser authUser
    ) {

        return new ModelAndView("admin/overview/kancelar/create")
            .addObject("authUser", authUser)
            .addObject("form", kancelarFormService.buildCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @ModelAttribute KancelarCreateForm form
    ) {
        kancelarFormService.create(form);
        return RedirectUtil.redirect("/admin/mistnost/kancelar");
    }

    @GetMapping("/{kancelarId}/edit")
    public ModelAndView edit(
        @PathVariable Integer kancelarId,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        KancelarView view = kancelarRepository.findById(kancelarId);
        return new ModelAndView("admin/overview/kancelar/edit")
            .addObject("id", view.getId())
            .addObject("form", kancelarFormService.buildUpdateForm(view));
    }

    @PostMapping("/{kancelarId}/update")
    public ModelAndView update(
        @PathVariable Integer kancelarId,
        @ModelAttribute KancelarUpdateForm form
    ) {
        form.setId(kancelarId);
        kancelarFormService.update(form);
        return RedirectUtil.redirect("/admin/mistnost/kancelar");
    }

    @GetMapping("/{kancelarId}/delete")
    public ModelAndView delete(
        @PathVariable Integer kancelarId
    ) {
        kancelarRepository.delete(kancelarId);
        return RedirectUtil.redirect("/admin/mistnost/kancelar");
    }

}
