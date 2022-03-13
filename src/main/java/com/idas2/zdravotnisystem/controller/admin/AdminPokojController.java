package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.NemocnicniPokojRepository;
import com.idas2.zdravotnisystem.db.view.NemocnicniPokojView;
import com.idas2.zdravotnisystem.form.mistnost.pokoj.PokojCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.pokoj.PokojUpdateForm;
import com.idas2.zdravotnisystem.service.form.PokojFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.mistnost.pokoj.PokojCreateFormValidator;
import com.idas2.zdravotnisystem.validator.mistnost.pokoj.PokojUpdateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/mistnost/pokoj")
public class AdminPokojController {

    private final PokojFormService pokojFormService;
    private final NemocnicniPokojRepository nemocnicniPokojRepository;

    private final PokojCreateFormValidator pokojCreateFormValidator;
    private final PokojUpdateFormValidator pokojUpdateFormValidator;

    @Autowired
    public AdminPokojController(
        PokojFormService pokojFormService,
        PokojCreateFormValidator pokojCreateFormValidator,
        PokojUpdateFormValidator pokojUpdateFormValidator,
        NemocnicniPokojRepository nemocnicniPokojRepository
    ) {
        this.pokojFormService = pokojFormService;
        this.pokojCreateFormValidator = pokojCreateFormValidator;
        this.pokojUpdateFormValidator = pokojUpdateFormValidator;
        this.nemocnicniPokojRepository = nemocnicniPokojRepository;
    }

    @InitBinder("createForm")
    protected void initCreateBinder(WebDataBinder binder) {
        binder.addValidators(pokojCreateFormValidator);
    }

    @InitBinder("updateForm")
    protected void initUpdateBinder(WebDataBinder binder) {
        binder.addValidators(pokojUpdateFormValidator);
    }

    @GetMapping("")
    public ModelAndView list(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView("admin/overview/pokoj/list")
            .addObject("list", nemocnicniPokojRepository.findAll());
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("admin/overview/pokoj/create")
            .addObject("createForm", new PokojCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @Validated @ModelAttribute("createForm") PokojCreateForm createForm,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("admin/overview/pokoj/create")
                .addObject("createForm", createForm);
        }
        pokojFormService.create(createForm);
        return RedirectUtil.redirect("/admin/mistnost/pokoj");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(
        @PathVariable("id") Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        NemocnicniPokojView view = nemocnicniPokojRepository.findById(id);
        return new ModelAndView("admin/overview/pokoj/update")
            .addObject("updateForm", pokojFormService.buildUpdateForm(view));
    }

    @PostMapping("/{id}/update")
    public ModelAndView update(
        @PathVariable("id") Integer id,
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("updateForm") PokojUpdateForm updateForm,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("admin/overview/pokoj/update")
                .addObject("updateForm", updateForm);
        }

        pokojFormService.update(updateForm);
        return RedirectUtil.redirect("/admin/mistnost/pokoj");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(
        @PathVariable("id") Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        nemocnicniPokojRepository.delete(id);
        return RedirectUtil.redirect("/admin/mistnost/pokoj");
    }


}
