package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lekar/profile")
public class LekarProfileController {

    @GetMapping("/info")
    public ModelAndView info(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView();
    }

    @PostMapping("/update")
    public ModelAndView update(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView();
    }
}
