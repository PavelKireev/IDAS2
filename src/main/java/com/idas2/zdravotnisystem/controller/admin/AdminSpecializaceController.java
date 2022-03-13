package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.Specializace;
import com.idas2.zdravotnisystem.db.repository.SpecializaceRepository;
import com.idas2.zdravotnisystem.form.specializace.SpecializaceCreateForm;
import com.idas2.zdravotnisystem.form.specializace.SpecializaceUpdateForm;
import com.idas2.zdravotnisystem.service.form.SpecializaceFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.specializace.SpecializaceCreateFormValidator;
import com.idas2.zdravotnisystem.validator.specializace.SpecializaceUpdateFormValidator;
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
@RequestMapping("/admin/specializace")
public class AdminSpecializaceController {

    private final SpecializaceRepository specializaceRepository;
    private final SpecializaceFormService specializaceFormService;

    private final SpecializaceCreateFormValidator specializaceCreateFormValidator;
    private final SpecializaceUpdateFormValidator specializaceUpdateFormValidator;

    @Autowired
    public AdminSpecializaceController(
        SpecializaceRepository specializaceRepository,
        SpecializaceFormService specializaceFormService,
        SpecializaceCreateFormValidator specializaceCreateFormValidator,
        SpecializaceUpdateFormValidator specializaceUpdateFormValidator
    ) {
        this.specializaceRepository = specializaceRepository;
        this.specializaceFormService = specializaceFormService;
        this.specializaceCreateFormValidator = specializaceCreateFormValidator;
        this.specializaceUpdateFormValidator = specializaceUpdateFormValidator;
    }

    @InitBinder("createForm")
    protected void initCreateBinder(WebDataBinder binder) {
        binder.addValidators(specializaceCreateFormValidator);
    }

    @InitBinder("updateForm")
    protected void initUpdateBinder(WebDataBinder binder) {
        binder.addValidators(specializaceUpdateFormValidator);
    }

    @GetMapping("")
    public ModelAndView list(
    ) {
        List<Specializace> list = specializaceRepository.findAll();

        return new ModelAndView("admin/overview/specializace/list")
            .addObject("list", list);
    }

    @GetMapping("/create")
    public ModelAndView create(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView("admin/overview/specializace/create")
            .addObject("authUser", authUser)
            .addObject("createForm", new SpecializaceCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("createForm") SpecializaceCreateForm form,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors())
            return new ModelAndView("admin/overview/specializace/create")
                .addObject("createForm", form);

        specializaceFormService.create(form);
        return RedirectUtil.redirect("/admin/specializace");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        Specializace entity =
            specializaceRepository.getOne(id);

        return new ModelAndView("/admin/overview/specializace/edit")
            .addObject("id", id)
            .addObject("authUser", authUser)
            .addObject("updateForm", specializaceFormService.buildUpdateForm(entity));
    }

    @PostMapping("/{id}/update")
    public ModelAndView update(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("updateForm") SpecializaceUpdateForm form,
        BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors())
            return new ModelAndView("admin/overview/specializace/create")
                .addObject("updateForm", form);

        form.setId(id);
        specializaceFormService.update(form);
        return RedirectUtil.redirect("/admin/specializace");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        specializaceRepository.delete(id);
        return RedirectUtil.redirect("/admin/specializace");
    }
}
