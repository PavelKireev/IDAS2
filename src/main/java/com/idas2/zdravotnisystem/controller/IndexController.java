package com.idas2.zdravotnisystem.controller;

import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("")
    public ModelAndView index() {
        return RedirectUtil.redirect("/sign-in");
    }

}
