package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.Pacient;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.PacientRepository;
import com.idas2.zdravotnisystem.db.repository.UzivatelRepository;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.uzivatel.pacient.PacientCreateForm;
import com.idas2.zdravotnisystem.form.uzivatel.pacient.PacientInfoForm;
import com.idas2.zdravotnisystem.security.UserDetailsServiceImpl;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/table/PACIENT")
public class AdminPacientController {

    private final PacientRepository repository;
    private final UzivatelRepository uzivatelRepository;
    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public AdminPacientController(
        PacientRepository repository,
        UzivatelRepository uzivatelRepository,
        UserDetailsServiceImpl userDetailsService
    ) {
        this.repository = repository;
        this.uzivatelRepository = uzivatelRepository;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/info")
    public ModelAndView info(
    ) {
        List<PacientView> list = repository.findAllView();
        return new ModelAndView("/admin/overview/pacient")
            .addObject("list", list);
    }

    @GetMapping("/create")
    public ModelAndView create(
    ) {
        PacientCreateForm pacientCreateForm = new PacientCreateForm();
        return new ModelAndView("/admin/overview/PACIENT/create")
            .addObject("pacientForm", pacientCreateForm);
    }

    @PostMapping("/save")
    public ModelAndView save(
        @ModelAttribute("pacientForm") PacientInfoForm pacientForm
    ) {

        return RedirectUtil.redirect("/admin/table/PACIENT/info");
    }

    @GetMapping("/update")
    public ModelAndView update(
    ) {
        List<Pacient> list = repository.findAll();
        return new ModelAndView("/admin/overview/pacient")
            .addObject("list", list);
    }

    @GetMapping("/{pacientId}/delete")
    public ModelAndView delete(
        @PathVariable Integer pacientId
    ) {
        repository.delete(pacientId);
        return RedirectUtil.redirect("/admin/table/PACIENT/info");
    }

    @GetMapping("/{pacientId}/simulate")
    public ModelAndView simulate(
        @PathVariable Integer pacientId,
        @AuthenticationPrincipal AuthUser authUser
    ) {

        User user = uzivatelRepository.findById(pacientId);
        authUser.setAdminId(authUser.getUser().getId());
        authUser.setSimulated(true);
        authUser.setUser(user);

        return RedirectUtil.redirect("/pacient/profile/info");
    }

    @GetMapping("/unsimulate")
    public ModelAndView unsimulate(
        @RequestParam Integer admId,
        @AuthenticationPrincipal AuthUser authUser
    ) {

        User user = uzivatelRepository.findById(admId);

        authUser.setAdminId(0);
        authUser.setSimulated(false);
        authUser.setUser(user);

        return RedirectUtil.redirect("/admin/table/PACIENT/info");
    }

}
