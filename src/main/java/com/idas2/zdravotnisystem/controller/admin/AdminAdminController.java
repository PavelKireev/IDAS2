package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.AdministratorRepository;
import com.idas2.zdravotnisystem.db.view.AdministratorView;
import com.idas2.zdravotnisystem.form.uzivatel.admin.AdminCreateForm;
import com.idas2.zdravotnisystem.form.uzivatel.admin.AdminUpdateForm;
import com.idas2.zdravotnisystem.service.form.AdminFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.uzivatel.admin.AdminCreateFormValidator;
import com.idas2.zdravotnisystem.validator.uzivatel.admin.AdminUpdateFormValidator;
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
@RequestMapping("/admin/uzivatel/admin")
public class AdminAdminController {

    private final AdminFormService adminFormService;
    private final AdministratorRepository administratorRepository;

    private final AdminCreateFormValidator adminCreateFormValidator;
    private final AdminUpdateFormValidator adminUpdateFormValidator;


    @Autowired
    public AdminAdminController(
        AdminFormService adminFormService,
        AdministratorRepository administratorRepository,
        AdminCreateFormValidator adminCreateFormValidator,
        AdminUpdateFormValidator adminUpdateFormValidator
    ) {
        this.adminFormService = adminFormService;
        this.administratorRepository = administratorRepository;
        this.adminCreateFormValidator = adminCreateFormValidator;
        this.adminUpdateFormValidator = adminUpdateFormValidator;
    }


    @InitBinder("createForm")
    protected void initCreateBinder(WebDataBinder binder) {
        binder.addValidators(adminCreateFormValidator);
    }

    @InitBinder("updateForm")
    protected void initUpdateBinder(WebDataBinder binder) {
        binder.addValidators(adminUpdateFormValidator);
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
            .addObject("createForm", adminFormService.buildCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("createForm") AdminCreateForm createForm,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors())
            return new ModelAndView("admin/overview/administrator/create")
                .addObject("createForm", createForm);

        adminFormService.save(createForm);
        return RedirectUtil.redirect("/admin/uzivatel/admin");
    }

    @GetMapping("/{adminId}/edit")
    public ModelAndView edit(
        @PathVariable Integer adminId,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        AdministratorView view = administratorRepository.findById(adminId);

        return new ModelAndView("admin/overview/administrator/edit")
            .addObject("authUser", authUser)
            .addObject("view", view)
            .addObject("updateForm", adminFormService.buildUpdateForm(view));
    }

    @PostMapping("/{adminId}/update")
    public ModelAndView update(
        @PathVariable Integer adminId,
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("updateForm") AdminUpdateForm updateForm,
        BindingResult bindingResult
    ) {
        AdministratorView view = administratorRepository.findById(adminId);

        if (bindingResult.hasErrors())
            return new ModelAndView("admin/overview/administrator/edit")
                .addObject("authUser", authUser)
                .addObject("view", view)
                .addObject("updateForm", updateForm);

        updateForm.setId(adminId);
        adminFormService.update(updateForm);

        return RedirectUtil.redirect("/admin/uzivatel/admin");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        administratorRepository.delete(id);
        return RedirectUtil.redirect("/admin/uzivatel/admin");
    }

}
