package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.Specializace;
import com.idas2.zdravotnisystem.db.repository.SpecializaceRepository;
import com.idas2.zdravotnisystem.form.specializace.SpecializaceCreateForm;
import com.idas2.zdravotnisystem.form.specializace.SpecializaceUpdateForm;
import com.idas2.zdravotnisystem.service.form.SpecializaceFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/specializace")
public class AdminSpecializaceController {

    private final SpecializaceRepository specializaceRepository;
    private final SpecializaceFormService specializaceFormService;

    @Autowired
    public AdminSpecializaceController(
        SpecializaceRepository specializaceRepository,
        SpecializaceFormService specializaceFormService
    ) {
        this.specializaceRepository = specializaceRepository;
        this.specializaceFormService = specializaceFormService;
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
            .addObject("form", new SpecializaceCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("form") SpecializaceCreateForm form
    ) {
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
            .addObject("form", specializaceFormService.buildUpdateForm(entity));
    }

    @PostMapping("/{id}/update")
    public ModelAndView update(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("form") SpecializaceUpdateForm form
    ) {
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
