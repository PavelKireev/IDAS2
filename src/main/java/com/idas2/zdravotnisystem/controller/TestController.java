package com.idas2.zdravotnisystem.controller;

import com.idas2.zdravotnisystem.component.AuthUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("test")
public class TestController {

    @GetMapping("")
    public ModelAndView test(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return
            new ModelAndView("user/profile")
                .addObject("authUser", authUser);
    }
}
