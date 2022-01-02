package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lekar/pacient")
public class LekarPacientController {

    @GetMapping("/list")
    public ModelAndView list(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView();
    }

    @PostMapping("/{pacientUuid}/add")
    public ModelAndView add(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser
    ){
        return new ModelAndView();
    }
    @GetMapping("/{pacientUuid}/edit")
    public ModelAndView edit(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser
    ){
        return new ModelAndView();
    }

    @PostMapping("/{pacientUuid}/update")
    public ModelAndView update(
        @PathVariable String pacientUuid,
        @AuthenticationPrincipal AuthUser authUser
    ){
        return new ModelAndView();
    }
}
