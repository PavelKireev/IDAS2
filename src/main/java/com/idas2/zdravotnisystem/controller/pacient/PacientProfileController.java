package com.idas2.zdravotnisystem.controller.pacient;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.HospitalizaceRepository;
import com.idas2.zdravotnisystem.db.repository.ObrazekRepository;
import com.idas2.zdravotnisystem.db.repository.PacientRepository;
import com.idas2.zdravotnisystem.db.repository.ProceduraRepository;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.uzivatel.pacient.PacientInfoForm;
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
@RequestMapping("/pacient")
public class PacientProfileController {

    private final PacientRepository pacientRepository;
    private final ObrazekRepository obrazekRepository;
    private final PacientFormService pacientFormService;
    private final ProceduraRepository proceduraRepository;
    private final HospitalizaceRepository hospitalizaceRepository;

    @Autowired
    public PacientProfileController(
        PacientRepository pacientRepository,
        ObrazekRepository obrazekRepository,
        PacientFormService pacientFormService,
        ProceduraRepository proceduraRepository,
        HospitalizaceRepository hospitalizaceRepository
    ) {
        this.pacientRepository = pacientRepository;
        this.obrazekRepository = obrazekRepository;
        this.pacientFormService = pacientFormService;
        this.proceduraRepository = proceduraRepository;
        this.hospitalizaceRepository = hospitalizaceRepository;
    }

    @GetMapping("/profile/info")
    public ModelAndView info(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        PacientView pacientView =
            pacientRepository
                .getPacientViewByUzivatelId(authUser.getUser().getId());

        User user = authUser.getUser();

        String file = null;

        if (Objects.nonNull(pacientView.getObrazekData())) {
            byte[] imgBytesAsBase64 = Base64.encodeBase64(pacientView.getObrazekData());
            String imgDataAsBase64 = new String(imgBytesAsBase64);
            file = String.format(
                "data:image/%s;base64,%s",
                pacientView.getObrazekPripona(), imgDataAsBase64
            );
        }

        return
            new ModelAndView("/pacient/profile")
                .addObject("user", user)
                .addObject("avatar", file)
                .addObject("pacientView", pacientView)
                .addObject("authUser", authUser)
                .addObject("pacientForm",
                    pacientFormService.buildInfoFormFromView(pacientView)
                );
    }

    @PostMapping("/profile/avatar")
    public ModelAndView avatar(
        @AuthenticationPrincipal AuthUser authUser,
        @RequestParam("obrazek") MultipartFile file
    ) throws IOException {
        obrazekRepository.upload(authUser.getUser(), file);
        return RedirectUtil.redirect("/pacient/profile/info");
    }

    @PostMapping("profile/info/update")
    public ModelAndView update(
        @ModelAttribute PacientInfoForm form,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        pacientFormService.updateInfoPaient(
            authUser.getUser().getId(), form
        );

        return RedirectUtil.redirect("/pacient/profile/info");
    }

    @GetMapping("/appointment")
    public ModelAndView appointments(
        @AuthenticationPrincipal AuthUser authUser
    ) {

        return new ModelAndView("")
            .addObject("authUser", authUser);
    }

    @GetMapping("/hospitalisation")
    public ModelAndView hospitalization(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView()
            .addObject("authUser", authUser);
    }
}
