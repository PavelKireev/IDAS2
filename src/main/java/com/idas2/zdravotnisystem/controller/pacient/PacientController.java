package com.idas2.zdravotnisystem.controller.pacient;

import com.idas2.zdravotnisystem.form.pacient.PacientSignUpForm;
import com.idas2.zdravotnisystem.service.form.PacientFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pacient")
public class PacientController {

    private final PacientFormService pacientFormService;

    @Autowired
    public PacientController(
        PacientFormService pacientFormService
    ) {
        this.pacientFormService = pacientFormService;
    }

    @GetMapping("/sign-up")
    public ModelAndView signUp(){

        return new ModelAndView("pacient/sign-up")
            .addObject("form", new PacientSignUpForm());
    }

    @PostMapping("/register")
    public ModelAndView register(
        @ModelAttribute("form") PacientSignUpForm form
    ){
        pacientFormService.signUp(form);
        return RedirectUtil.redirect("/");
    }

}
