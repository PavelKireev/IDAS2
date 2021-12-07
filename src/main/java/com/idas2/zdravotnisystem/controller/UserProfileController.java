package com.idas2.zdravotnisystem.controller;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.form.UserUpdateForm;
import com.idas2.zdravotnisystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profile")
public class UserProfileController {

    private final UserService userService;

    @Autowired
    public UserProfileController(
        UserService userService
    ) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public ModelAndView info(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return
            new ModelAndView("user/profile")
                .addObject("authUser", authUser);
    }

    @PostMapping("/update")
    public ModelAndView update(
        @ModelAttribute UserUpdateForm form
        ){

    }
}
