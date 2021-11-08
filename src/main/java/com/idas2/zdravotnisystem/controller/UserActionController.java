package com.idas2.zdravotnisystem.controller;

import com.idas2.zdravotnisystem.validator.SignInValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserActionController {

    private final SignInValidator signInValidator;

    @Autowired
    public UserActionController(
        SignInValidator signInValidator
    ) {
        this.signInValidator = signInValidator;
    }

    @InitBinder("signInForm")
    public void setSignInValidator(WebDataBinder binder) {
        binder.addValidators(signInValidator);
    }

    @PostMapping("/sign-in")
    public ModelAndView signIn() {
        return new ModelAndView("auth/signin");
    }

}
