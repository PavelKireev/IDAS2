package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.OrdinaceRepository;
import com.idas2.zdravotnisystem.db.view.OrdinaceView;
import com.idas2.zdravotnisystem.form.mistnost.ordinace.OrdinaceCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.ordinace.OrdinaceUpdateForm;
import com.idas2.zdravotnisystem.service.form.OrdinaceFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.mistnost.ordinace.OrdinaceCreateFormValidator;
import com.idas2.zdravotnisystem.validator.mistnost.ordinace.OrdinaceUpdateFormValidator;
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
@RequestMapping("/admin/mistnost/ordinace")
public class AdminOrdinaceController {

    private final OrdinaceRepository ordinaceRepository;
    private final OrdinaceFormService ordinaceFormService;

    private final OrdinaceCreateFormValidator createFormValidator;
    private final OrdinaceUpdateFormValidator ordinaceUpdateFormValidator;

    @Autowired
    public AdminOrdinaceController(
        OrdinaceRepository ordinaceRepository,
        OrdinaceFormService ordinaceFormService,
        OrdinaceCreateFormValidator createFormValidator,
        OrdinaceUpdateFormValidator ordinaceUpdateFormValidator
    ) {
        this.ordinaceRepository = ordinaceRepository;
        this.ordinaceFormService = ordinaceFormService;
        this.createFormValidator = createFormValidator;
        this.ordinaceUpdateFormValidator = ordinaceUpdateFormValidator;
    }

    @InitBinder("createForm")
    protected void initCreateBinder(WebDataBinder binder) {
        binder.addValidators(createFormValidator);
    }

    @InitBinder("updateForm")
    protected void initUpdateBinder(WebDataBinder binder) {
        binder.addValidators(ordinaceUpdateFormValidator);
    }


    @GetMapping("")
    public ModelAndView list(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<OrdinaceView> list = ordinaceRepository.findAll();

        return new ModelAndView("admin/overview/ordinace/list")
            .addObject("list", list)
            .addObject("authUser", authUser);
    }

    @GetMapping("/create")
    public ModelAndView create(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView("admin/overview/ordinace/create")
            .addObject("authUser", authUser)
            .addObject("form", new OrdinaceCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("createForm") OrdinaceCreateForm createForm,
        BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("admin/overview/ordinace/create")
                .addObject("authUser", authUser)
                .addObject("createForm", createForm);
        }
        ordinaceFormService.create(createForm);
        return RedirectUtil.redirect("/admin/mistnost/ordinace");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        OrdinaceView view = ordinaceRepository.findById(id);

        return new ModelAndView("admin/overview/ordinace/edit")
            .addObject("id", view.getId())
            .addObject("form", ordinaceFormService.buildUpdateForm(view));
    }

    @PostMapping("/{ordinaceId}/update")
    public ModelAndView update(
        @PathVariable Integer ordinaceId,
        @Validated @ModelAttribute("updateForm") OrdinaceUpdateForm updateForm,
        BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("admin/overview/ordinace/edit")
                .addObject("id", ordinaceId)
                .addObject("updateForm", updateForm);
        }

        updateForm.setId(ordinaceId);
        ordinaceFormService.update(updateForm);
        return RedirectUtil.redirect("/admin/mistnost/ordinace");
    }

    @GetMapping("{ordinaceId}/delete")
    public ModelAndView delete(
        @PathVariable Integer ordinaceId
    ) {
        ordinaceRepository.delete(ordinaceId);
        return RedirectUtil.redirect("/admin/mistnost/ordinace");
    }
}
