package com.idas2.zdravotnisystem.controller;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.Obrazek;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.ObrazekRepository;
import com.idas2.zdravotnisystem.db.repository.PacientRepository;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.PacientInfoForm;
import com.idas2.zdravotnisystem.form.UserUpdateForm;
import com.idas2.zdravotnisystem.service.UserService;
import com.idas2.zdravotnisystem.service.form.PacientFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Objects;

@Controller
@RequestMapping("/profile")
public class UserProfileController {

    private final UserService userService;
    private final PacientRepository pacientRepository;
    private final ObrazekRepository obrazekRepository;
    private final PacientFormService pacientFormService;

    @Autowired
    public UserProfileController(
        UserService userService,
        PacientRepository pacientRepository,
        ObrazekRepository obrazekRepository,
        PacientFormService pacientFormService
    ) {
        this.userService = userService;
        this.pacientRepository = pacientRepository;
        this.obrazekRepository = obrazekRepository;
        this.pacientFormService = pacientFormService;
    }

    @GetMapping("/info")
    public ModelAndView info(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        PacientView pacientView =
            pacientRepository
                .getPacientViewByUzivatelId(authUser.getUser().getId());

        User user = authUser.getUser();
        Obrazek obrazek =
            obrazekRepository.getOne(authUser.getUser().getObrazekIdObrazek());
        String file = null;

        if (Objects.nonNull(obrazek)) {
            byte[] imgBytesAsBase64 = Base64.encodeBase64(obrazek.getData());
            String imgDataAsBase64 = new String(imgBytesAsBase64);
            file = String.format(
                "data:image/%s;base64,%s",
                obrazek.getPripona(), imgDataAsBase64
            );
        }

        return
            new ModelAndView("user/profile")
                .addObject("user", user)
                .addObject("avatar", file)
                .addObject("pacientView", pacientView)
                .addObject("pacientForm",
                    pacientFormService.buildInfoFormFromView(pacientView)
                );
    }

    @PostMapping("/avatar")
    public ModelAndView avatar(
        @AuthenticationPrincipal AuthUser authUser,
        @RequestParam("obrazek") MultipartFile file
    ) throws IOException {
        obrazekRepository.upload(authUser.getUser(), file);
        return RedirectUtil.redirect("/profile/info");
    }

    @PostMapping("/update")
    public ModelAndView update(
        @ModelAttribute PacientInfoForm form
    ) {

        return null;
    }
}
