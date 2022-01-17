package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.AdministratorRepository;
import com.idas2.zdravotnisystem.db.view.AdministratorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/admin")
public class AdminAdminController {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdminAdminController(
        AdministratorRepository administratorRepository
    ) {
        this.administratorRepository = administratorRepository;
    }

    @GetMapping("/list")
    public ModelAndView list(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<AdministratorView> list = administratorRepository.findAllView();

        return new ModelAndView("admin/overview/administrator/list")
            .addObject("list", list)
            .addObject("authUser", authUser);
    }

    @GetMapping("/add")
    public ModelAndView add(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<AdministratorView> list = administratorRepository.findAllView();

        return new ModelAndView("admin/overview/administrator/list")
            .addObject("list", list)
            .addObject("authUser", authUser);
    }

    @PostMapping("/create")
    public ModelAndView create(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<AdministratorView> list = administratorRepository.findAllView();

        return new ModelAndView("admin/overview/administrator/list")
            .addObject("list", list)
            .addObject("authUser", authUser);
    }

    @GetMapping("/edit")
    public ModelAndView edit(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<AdministratorView> list = administratorRepository.findAllView();

        return new ModelAndView("admin/overview/administrator/list")
            .addObject("list", list)
            .addObject("authUser", authUser);
    }

    @GetMapping("/update")
    public ModelAndView update(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<AdministratorView> list = administratorRepository.findAllView();

        return new ModelAndView("admin/overview/administrator/list")
            .addObject("list", list)
            .addObject("authUser", authUser);
    }


}
