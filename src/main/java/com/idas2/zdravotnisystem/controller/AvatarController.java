package com.idas2.zdravotnisystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/avatar")
public class AvatarController {

    @PostMapping
    public ModelAndView updateAvatar(
        MultipartFile avatar
    ) {
        return null;
    }

}
