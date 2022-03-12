package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.AdministratorRepository;
import com.idas2.zdravotnisystem.db.repository.LogRepository;
import com.idas2.zdravotnisystem.db.repository.ObrazekRepository;
import com.idas2.zdravotnisystem.db.view.AdministratorView;
import com.idas2.zdravotnisystem.form.uzivatel.admin.AdminUpdateForm;
import com.idas2.zdravotnisystem.service.form.AdminFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.uzivatel.admin.AdminUpdateFormValidator;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final LogRepository logRepositozry;
    private final AdminFormService adminFormService;
    private final ObrazekRepository obrazekRepository;
    private final AdministratorRepository administratorRepository;

    private final AdminUpdateFormValidator adminUpdateFormValidator;

    @Autowired
    public AdminController(
        LogRepository logRepositozry,
        AdminFormService adminFormService,
        ObrazekRepository obrazekRepository,
        AdministratorRepository administratorRepository,
        AdminUpdateFormValidator adminUpdateFormValidator
    ) {
        this.logRepositozry = logRepositozry;
        this.adminFormService = adminFormService;
        this.obrazekRepository = obrazekRepository;
        this.administratorRepository = administratorRepository;
        this.adminUpdateFormValidator = adminUpdateFormValidator;
    }

    @InitBinder("updateForm")
    protected void initUpdateBinder(WebDataBinder binder) {
        binder.addValidators(adminUpdateFormValidator);
    }

    @GetMapping("/profile/info")
    public ModelAndView info(
        @AuthenticationPrincipal AuthUser authUser
    ) {

        User user = authUser.getUser();

        AdministratorView view =
            administratorRepository
                .findById(user.getId());


        String file = null;

        if (Objects.nonNull(view.getObrazekData())) {
            byte[] imgBytesAsBase64 = Base64.encodeBase64(view.getObrazekData());
            String imgDataAsBase64 = new String(imgBytesAsBase64);
            file = String.format(
                "data:image/%s;base64,%s",
                view.getObrazekPripona(), imgDataAsBase64
            );
        }

        return
            new ModelAndView("/admin/profile/info")
                .addObject("user", user)
                .addObject("avatar", file)
                .addObject("authUser", authUser)
                .addObject("view", view)
                .addObject("updateForm",
                    adminFormService.buildUpdateForm(view)
                );
    }

    @PostMapping("/profile/avatar")
    public ModelAndView avatar(
        @AuthenticationPrincipal AuthUser authUser,
        @RequestParam("obrazek") MultipartFile file
    ) throws IOException {
        obrazekRepository.upload(authUser.getUser(), file);
        return RedirectUtil.redirect("/admin/profile/info");
    }

    @PostMapping("profile/info/update")
    public ModelAndView update(
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("updateForm") AdminUpdateForm updateForm,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {

            User user = authUser.getUser();

            AdministratorView view =
                administratorRepository
                    .findById(user.getId());


            String file = null;

            if (Objects.nonNull(view.getObrazekData())) {
                byte[] imgBytesAsBase64 = Base64.encodeBase64(view.getObrazekData());
                String imgDataAsBase64 = new String(imgBytesAsBase64);
                file = String.format(
                    "data:image/%s;base64,%s",
                    view.getObrazekPripona(), imgDataAsBase64
                );
            }

            return
                new ModelAndView("/admin/profile/info")
                    .addObject("user", user)
                    .addObject("avatar", file)
                    .addObject("authUser", authUser)
                    .addObject("view", view)
                    .addObject("updateForm",
                        adminFormService.buildUpdateForm(view)
                    );
        }

        updateForm.setId(authUser.getUser().getId());
        adminFormService.update(updateForm);

        return RedirectUtil.redirect("/admin/profile/info");
    }


    @GetMapping("/overview")
    public ModelAndView overview(){

        List<String> list = new ArrayList<>();

        list.add("ADMINISTRATOR");
        list.add("HOSPITALIZACE");
        list.add("KANCELAR");
        list.add("LEKAR");
        list.add("LOG");
        list.add("MISTNOST");
        list.add("NEMOCNICNI_POKOJ");
        list.add("OBRAZEK");
        list.add("ODEBRANY_UZIVATEL");
        list.add("ORDINACE");
        list.add("PACIENT");
        list.add("POJISTENI");
        list.add("POJISTOVNA");
        list.add("PROCEDURA");
        list.add("SPECIALIZACE");
        list.add("TYP_PROCEDURY");
        list.add("TYP_ZARIZENI");
        list.add("ZARIZENI");
        list.add("ZAZNAM");
        list.add("ZDRAVOTNI_KARTA");

        return new ModelAndView("admin/overview/overview")
            .addObject("list", list);
    }

}
