package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.KancelarRepository;
import com.idas2.zdravotnisystem.db.view.KancelarView;
import com.idas2.zdravotnisystem.form.mistnost.kancelar.KancelarCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.kancelar.KancelarUpdateForm;
import com.idas2.zdravotnisystem.service.form.KancelarFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.mistnost.kancelar.KancelarCreateFormValidator;
import com.idas2.zdravotnisystem.validator.mistnost.kancelar.KancelarUpdateFormValidator;
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
@RequestMapping("/admin/mistnost/kancelar")
public class AdminKancelarController {

    private final KancelarRepository kancelarRepository;
    private final KancelarFormService kancelarFormService;
    private final KancelarCreateFormValidator kancelarCreateFormValidator;
    private final KancelarUpdateFormValidator kancelarUpdateFormValidator;

    @Autowired
    public AdminKancelarController(
        KancelarRepository kancelarRepository,
        KancelarFormService kancelarFormService,
        KancelarCreateFormValidator kancelarCreateFormValidator,
        KancelarUpdateFormValidator kancelarUpdateFormValidator
    ) {
        this.kancelarRepository = kancelarRepository;
        this.kancelarFormService = kancelarFormService;
        this.kancelarCreateFormValidator = kancelarCreateFormValidator;
        this.kancelarUpdateFormValidator = kancelarUpdateFormValidator;
    }


    @InitBinder("createForm")
    protected void initCreateBinder(WebDataBinder binder) {
        binder.addValidators(kancelarCreateFormValidator);
    }

    @InitBinder("updateForm")
    protected void initUpdateBinder(WebDataBinder binder) {
        binder.addValidators(kancelarUpdateFormValidator);
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
            .addObject("createForm", kancelarFormService.buildCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("createForm") KancelarCreateForm createForm,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("admin/overview/kancelar/create")
                .addObject("authUser", authUser)
                .addObject("createForm", kancelarFormService.buildCreateForm());
        }
        kancelarFormService.create(createForm);
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
            .addObject("updateForm", kancelarFormService.buildUpdateForm(view));
    }

    @PostMapping("/{kancelarId}/update")
    public ModelAndView update(
        @PathVariable Integer kancelarId,
        @Validated @ModelAttribute("updateForm") KancelarUpdateForm updateForm,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("admin/overview/kancelar/edit")
                .addObject("id", kancelarId)
                .addObject("updateForm", updateForm);
        }

        updateForm.setId(kancelarId);
        kancelarFormService.update(updateForm);
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
