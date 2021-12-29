package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.LekarRepository;
import com.idas2.zdravotnisystem.db.repository.ObrazekRepository;
import com.idas2.zdravotnisystem.db.view.LekarView;
import com.idas2.zdravotnisystem.form.LekarProfileUpdateForm;
import com.idas2.zdravotnisystem.service.form.LekarFormService;
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
@RequestMapping("/lekar/profile")
public class LekarProfileController {

    private final LekarRepository lekarRepository;
    private final LekarFormService lekarFormService;
    private final ObrazekRepository obrazekRepository;

    @Autowired
    public LekarProfileController(
        LekarRepository lekarRepository,
        LekarFormService lekarFormService,
        ObrazekRepository obrazekRepository
    ) {
        this.lekarRepository = lekarRepository;
        this.lekarFormService = lekarFormService;
        this.obrazekRepository = obrazekRepository;
    }


    @GetMapping("/profile/info")
    public ModelAndView info(
        @AuthenticationPrincipal AuthUser authUser
    ) {

        User user = authUser.getUser();

        LekarView lekarView =
            lekarRepository
                .getViewById(user.getId());


        String file = null;

        if (Objects.nonNull(lekarView.getObrazek())) {
            byte[] imgBytesAsBase64 = Base64.encodeBase64(lekarView.getObrazek());
            String imgDataAsBase64 = new String(imgBytesAsBase64);
            file = String.format(
                "data:image/%s;base64,%s",
                lekarView.getObrazekPripona(), imgDataAsBase64
            );
        }

        return
            new ModelAndView("/pacient/profile")
                .addObject("user", user)
                .addObject("avatar", file)
                .addObject("lekarView", lekarView)
                .addObject("lekarForm",
                    lekarFormService.buildInfoFormFromView(lekarView)
                );
    }

    @PostMapping("/profile/avatar")
    public ModelAndView avatar(
        @AuthenticationPrincipal AuthUser authUser,
        @RequestParam("obrazek") MultipartFile file
    ) throws IOException {
        obrazekRepository.upload(authUser.getUser(), file);
        return RedirectUtil.redirect("/lekar/profile/info");
    }

    @PostMapping("profile/info/update")
    public ModelAndView update(
        @ModelAttribute LekarProfileUpdateForm form,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        lekarFormService.update(
            form,
            authUser.getUser().getId()
        );

        return RedirectUtil.redirect("/lekar/profile/info");
    }
}
