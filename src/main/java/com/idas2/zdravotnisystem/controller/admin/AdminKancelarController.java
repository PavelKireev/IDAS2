package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.KancelarRepository;
import com.idas2.zdravotnisystem.db.view.KancelarView;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/kancelar")
public class AdminKancelarController {

    private final KancelarRepository kancelarRepository;

    @Autowired
    public AdminKancelarController(
        KancelarRepository kancelarRepository
    ) {
        this.kancelarRepository = kancelarRepository;
    }

    @GetMapping("/list")
    public ModelAndView list(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<KancelarView> list = kancelarRepository.findAllView();

        return new ModelAndView()
            .addObject("list", list)
            .addObject("authUser", authUser);
    }

    @GetMapping("/create")
    public ModelAndView create() {

        return new ModelAndView("");
    }

    @PostMapping("/save")
    public ModelAndView save() {
        return RedirectUtil.redirect("");
    }

    @GetMapping("/edit")
    public ModelAndView edit(

    ) {
        return new ModelAndView();
    }

    @PostMapping("/update")
    public ModelAndView update(

    ) {
        return RedirectUtil.redirect("");
    }

    @GetMapping("/delete")
    public ModelAndView delete(

    ) {
        return RedirectUtil.redirect("");
    }

}
