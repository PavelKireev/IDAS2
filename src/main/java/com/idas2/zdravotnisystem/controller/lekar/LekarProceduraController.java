package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.form.ProceduraCreateForm;
import org.apache.tomcat.jni.Proc;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lekar/procedura")
public class LekarProceduraController {

    @GetMapping("/list")
    public ModelAndView procedury(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView();
    }

    @GetMapping("/add")
    public ModelAndView add(
        @AuthenticationPrincipal AuthUser authUser
    ) {

        return new ModelAndView()
            .addObject("form", new ProceduraCreateForm());
    }

    @PostMapping("/create")
    public ModelAndView create(
        @ModelAttribute("form") ProceduraCreateForm form
    ) {
        return new ModelAndView();
    }

    @GetMapping("/delete")
    public ModelAndView delete(
        @RequestParam("id") String uuid
    ) {
        return new ModelAndView();
    }

}
