package com.idas2.zdravotnisystem.controller.pacient;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.*;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.uzivatel.PasswordUpdateForm;
import com.idas2.zdravotnisystem.form.uzivatel.pacient.PacientInfoForm;
import com.idas2.zdravotnisystem.service.form.PacientFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.uzivatel.PasswordUpdateFormValidator;
import com.idas2.zdravotnisystem.validator.uzivatel.pacient.PacientInfoFormVaidator;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
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
    private final UzivatelRepository uzivatelRepository;
    private final PacientFormService pacientFormService;
    private final ProceduraRepository proceduraRepository;
    private final HospitalizaceRepository hospitalizaceRepository;

    private final PacientInfoFormVaidator pacientInfoFormVaidator;
    private final PasswordUpdateFormValidator passwordUpdateFormValidator;

    @Autowired
    public PacientProfileController(
        PacientRepository pacientRepository,
        ObrazekRepository obrazekRepository,
        UzivatelRepository uzivatelRepository,
        PacientFormService pacientFormService,
        ProceduraRepository proceduraRepository,
        HospitalizaceRepository hospitalizaceRepository,
        PacientInfoFormVaidator pacientInfoFormVaidator,
        PasswordUpdateFormValidator passwordUpdateFormValidator
    ) {
        this.pacientRepository = pacientRepository;
        this.obrazekRepository = obrazekRepository;
        this.uzivatelRepository = uzivatelRepository;
        this.pacientFormService = pacientFormService;
        this.proceduraRepository = proceduraRepository;
        this.hospitalizaceRepository = hospitalizaceRepository;
        this.pacientInfoFormVaidator = pacientInfoFormVaidator;
        this.passwordUpdateFormValidator = passwordUpdateFormValidator;
    }

    @InitBinder("updateForm")
    protected void initUpdateBinder(WebDataBinder binder) {
        binder.addValidators(pacientInfoFormVaidator);
    }

    @InitBinder("passwordForm")
    protected void initPasswordUpdateBinder(WebDataBinder binder) {
        binder.addValidators(passwordUpdateFormValidator);
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
                .addObject("updateForm",
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
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("updateForm") PacientInfoForm updateForm,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
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
                    .addObject("updateForm", updateForm);
        }

        pacientFormService.updateInfoPaient(
            authUser.getUser().getId(), updateForm
        );

        return RedirectUtil.redirect("/pacient/profile/info");
    }

    @GetMapping("/password/change")
    public ModelAndView passwordChange(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        PasswordUpdateForm passwordForm = new PasswordUpdateForm();
        passwordForm.setId(authUser.getUser().getId());
        return new ModelAndView("pacient/password")
            .addObject("passwordForm", passwordForm);
    }

    @PostMapping("/password/update")
    public ModelAndView passwordUpdate(
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("passwordForm") PasswordUpdateForm passwordForm,
        BindingResult bindingResult
    ) {
        passwordForm.setId(authUser.getUser().getId());

        if (bindingResult.hasErrors())
            return new ModelAndView("pacient/password")
                .addObject("passwordForm", passwordForm);

        uzivatelRepository.updatePassword(
            authUser.getUser().getId(),
            passwordForm.getPassword()
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
