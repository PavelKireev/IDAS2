package com.idas2.zdravotnisystem.controller.pacient;

import com.idas2.zdravotnisystem.form.uzivatel.pacient.PacientSignUpForm;
import com.idas2.zdravotnisystem.service.form.PacientFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.uzivatel.pacient.PacientSignUpFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pacient")
public class PacientController {

    private final PacientFormService pacientFormService;
    private final PacientSignUpFormValidator pacientSignUpFormValidator;

    @Autowired
    public PacientController(
        PacientFormService pacientFormService,
        PacientSignUpFormValidator pacientSignUpFormValidator
    ) {
        this.pacientFormService = pacientFormService;
        this.pacientSignUpFormValidator = pacientSignUpFormValidator;
    }

    @InitBinder("form")
    protected void initUpdateBinder(WebDataBinder binder) {
        binder.addValidators(pacientSignUpFormValidator);
    }

    @GetMapping("/sign-up")
    public ModelAndView signUp(){

        return new ModelAndView("pacient/sign-up")
            .addObject("form", new PacientSignUpForm());
    }

    @PostMapping("/register")
    public ModelAndView register(
        @Validated @ModelAttribute("form") PacientSignUpForm form,
        BindingResult bindingResult
    ){
        if(bindingResult.hasErrors())
            return new ModelAndView("pacient/sign-up")
                .addObject("form", form);

        pacientFormService.signUp(form);
        return RedirectUtil.redirect("/");
    }

}
