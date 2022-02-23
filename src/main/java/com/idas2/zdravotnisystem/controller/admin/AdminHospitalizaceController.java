package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.HospitalizaceRepository;
import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceCreateForm;
import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceUpdateForm;
import com.idas2.zdravotnisystem.service.form.HospitalizaceFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/hospitalizace")
public class AdminHospitalizaceController {

    private final HospitalizaceRepository hospitalizaceRepository;
    private final HospitalizaceFormService hospitalizaceFormService;

    @Autowired
    public AdminHospitalizaceController(
        HospitalizaceRepository hospitalizaceRepository,
        HospitalizaceFormService hospitalizaceFormService
    ) {
        this.hospitalizaceRepository = hospitalizaceRepository;
        this.hospitalizaceFormService = hospitalizaceFormService;
    }

    @GetMapping("")
    public ModelAndView list(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView("admin/overview/hospitalizace/list")
            .addObject("authUser", authUser)
            .addObject("list", hospitalizaceRepository.findAll());
    }

    @GetMapping("/create")
    public ModelAndView create(
        @AuthenticationPrincipal AuthUser authUser
    ) {

        return new ModelAndView("admin/overview/hospitalizace/create")
            .addObject("authUser", authUser)
            .addObject("create", new HospitalizaceCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("form") HospitalizaceCreateForm form
    ) {
        hospitalizaceFormService.create(form);
        return RedirectUtil.redirect("/admin/hospitalizace/list");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {

        return new ModelAndView("/admin/overview/hospitalizace/edit")
            .addObject("authUser", authUser)
            .addObject("form", new HospitalizaceUpdateForm());
    }

    @PostMapping("/{id}/update")
    public ModelAndView update(
        @RequestParam Integer hospId,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("form") HospitalizaceUpdateForm form
    ) {
        form.setId(hospId);
        hospitalizaceFormService.update(form);
        return RedirectUtil.redirect("/admin/hospitalizace/list");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        hospitalizaceRepository.delete(id);
        return RedirectUtil.redirect("/admin/hospitalizace/list");
    }
}
