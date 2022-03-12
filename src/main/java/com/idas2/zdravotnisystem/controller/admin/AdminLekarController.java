package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.Specializace;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.KancelarRepository;
import com.idas2.zdravotnisystem.db.repository.LekarRepository;
import com.idas2.zdravotnisystem.db.repository.SpecializaceRepository;
import com.idas2.zdravotnisystem.db.repository.UzivatelRepository;
import com.idas2.zdravotnisystem.db.view.KancelarView;
import com.idas2.zdravotnisystem.db.view.LekarView;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarCreateForm;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarUpdateForm;
import com.idas2.zdravotnisystem.service.form.LekarFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.uzivatel.lekar.LekarCreateFormValidator;
import com.idas2.zdravotnisystem.validator.uzivatel.lekar.LekarUpdateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/uzivatel/lekar")
public class AdminLekarController {

    private final LekarRepository lekarRepository;
    private final LekarFormService lekarFormService;
    private final KancelarRepository kancelarRepository;
    private final UzivatelRepository uzivatelRepository;
    private final SpecializaceRepository specializaceRepository;
    private final LekarCreateFormValidator lekarCreateFormValidator;
    private final LekarUpdateFormValidator lekarUpdateFormValidator;

    @Autowired
    public AdminLekarController(
        LekarRepository lekarRepository,
        LekarFormService lekarFormService,
        KancelarRepository kancelarRepository,
        UzivatelRepository uzivatelRepository,
        SpecializaceRepository specializaceRepository,
        LekarCreateFormValidator lekarCreateFormValidator,
        LekarUpdateFormValidator lekarUpdateFormValidator
    ) {
        this.lekarRepository = lekarRepository;
        this.lekarFormService = lekarFormService;
        this.kancelarRepository = kancelarRepository;
        this.uzivatelRepository = uzivatelRepository;
        this.specializaceRepository = specializaceRepository;
        this.lekarCreateFormValidator = lekarCreateFormValidator;
        this.lekarUpdateFormValidator = lekarUpdateFormValidator;
    }


    @InitBinder("createForm")
    protected void initCreateBinder(WebDataBinder binder) {
        binder.addValidators(lekarCreateFormValidator);
    }

    @InitBinder("updateForm")
    protected void initUpdateBinder(WebDataBinder binder) {
        binder.addValidators(lekarUpdateFormValidator);
    }


    @GetMapping("")
    public ModelAndView info(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<LekarView> list = lekarRepository.findAllView();
        return new ModelAndView("admin/overview/lekar/list")
            .addObject("list", list)
            .addObject("authUser", authUser);
    }

    @GetMapping("/create")
    public ModelAndView create(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<Specializace> specializaceList = specializaceRepository.findAll();
        List<KancelarView> kancelarList = kancelarRepository.findAllView();

        return new ModelAndView("admin/overview/lekar/create")
            .addObject("authUser", authUser)
            .addObject("createForm", new LekarCreateForm())
            .addObject("specializaceList", specializaceList)
            .addObject("kancelarList", kancelarList);
    }

    @PostMapping("/save")
    public ModelAndView save(
        @Validated @ModelAttribute("createForm") LekarCreateForm createForm,
        BindingResult bindingResult,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        if (bindingResult.hasErrors()) {
            List<Specializace> specializaceList = specializaceRepository.findAll();
            List<KancelarView> kancelarList = kancelarRepository.findAllView();

            return new ModelAndView("admin/overview/lekar/create")
                .addObject("authUser", authUser)
                .addObject("createForm", createForm)
                .addObject("specializaceList", specializaceList)
                .addObject("kancelarList", kancelarList);
        }

        lekarFormService.save(createForm);
        return RedirectUtil.redirect("/admin/uzivatel/lekar");
    }

    @GetMapping("/{lekarId}/edit")
    public ModelAndView edit(
        @PathVariable Integer lekarId,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        LekarView view = lekarRepository.getViewById(lekarId);
        LekarUpdateForm form = lekarFormService.buildUpdateForm(view);

        return new ModelAndView("admin/overview/lekar/edit")
            .addObject("form", form)
            .addObject("authUser", authUser);
    }

    @PostMapping("/{lekarId}/update")
    public ModelAndView update(
        @PathVariable Integer lekarId,
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("updateForm") LekarUpdateForm updateForm,
        BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("admin/overview/lekar/edit")
                .addObject("updateForm", updateForm)
                .addObject("authUser", authUser);
        }

        updateForm.setId(lekarId);
        lekarFormService.update(updateForm);

        return RedirectUtil.redirect("/admin/uzivatel/lekar");
    }

    @GetMapping("/{lekarId}/delete")
    public ModelAndView delete(
        @PathVariable Integer lekarId,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        lekarRepository.delete(lekarId);
        return RedirectUtil.redirect("/admin/uzivatel/lekar");
    }

    @GetMapping("/{lekarId}/simulate")
    public ModelAndView simulate(
        @PathVariable Integer lekarId,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        User user = uzivatelRepository.findById(lekarId);
        authUser.setAdminId(authUser.getUser().getId());
        authUser.setSimulated(true);
        authUser.setUser(user);

        return RedirectUtil.redirect("/lekar/profile/info");
    }

    @GetMapping("/unsimulate")
    public ModelAndView unsimulate(
        @RequestParam Integer admId,
        @AuthenticationPrincipal AuthUser authUser
    ) {

        User user = uzivatelRepository.findById(admId);

        authUser.setAdminId(0);
        authUser.setSimulated(false);
        authUser.setUser(user);

        return RedirectUtil.redirect("/admin/uzivatel/lekar");
    }
}
