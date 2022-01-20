package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.AdministratorRepository;
import com.idas2.zdravotnisystem.db.view.AdministratorView;
import com.idas2.zdravotnisystem.form.uzivatel.admin.AdminCreateForm;
import com.idas2.zdravotnisystem.form.uzivatel.admin.AdminUpdateForm;
import com.idas2.zdravotnisystem.service.form.AdminFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/uzivatel/admin")
public class AdminAdminController {

    private final AdminFormService adminFormService;
    private final AdministratorRepository administratorRepository;


    @Autowired
    public AdminAdminController(
        AdminFormService adminFormService,
        AdministratorRepository administratorRepository
    ) {
        this.adminFormService = adminFormService;
        this.administratorRepository = administratorRepository;
    }

    @GetMapping("")
    public ModelAndView list(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<AdministratorView> list = administratorRepository.findAllView();

        return new ModelAndView("admin/overview/administrator/list")
            .addObject("list", list)
            .addObject("authUser", authUser);
    }

    @GetMapping("/create")
    public ModelAndView add(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView("admin/overview/administrator/create")
            .addObject("authUser", authUser)
            .addObject("form", adminFormService.buildCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @ModelAttribute AdminCreateForm form,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        adminFormService.save(form);
        return RedirectUtil.redirect("/admin/uzivatel/admin");
    }

    @GetMapping("{adminId}/edit")
    public ModelAndView edit(
        @PathVariable Integer adminId,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        AdministratorView view = administratorRepository.findById(adminId);

        return new ModelAndView("admin/overview/administrator/edit")
            .addObject("authUser", authUser)
            .addObject("view", view)
            .addObject("form", adminFormService.buildUpdateForm(view));
    }

    @PostMapping("/{adminId}/update")
    public ModelAndView update(
        @PathVariable Integer adminId,
        @ModelAttribute AdminUpdateForm form,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        form.setId(adminId);
        adminFormService.update(form);

        return RedirectUtil.redirect("/admin/uzivatel/admin");
    }

}
