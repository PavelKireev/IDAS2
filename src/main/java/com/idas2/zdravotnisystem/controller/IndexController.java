package com.idas2.zdravotnisystem.controller;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("")
    public ModelAndView index(
        @AuthenticationPrincipal AuthUser authUser
        ) {
        String role =
            authUser.getAuthorities().stream().findFirst()
                .orElseThrow(RuntimeException::new).getAuthority();

        if(role.equals("PACIENT"))
            return RedirectUtil.redirect("/pacient/profile/info");

        if(role.equals("LEKAR"))
            return RedirectUtil.redirect("/lekar/profile/info");

        if(role.equals("ADMIN"))
            return RedirectUtil.redirect("/admin");

        return RedirectUtil.redirect("/pacient/profile/info");
    }

}
