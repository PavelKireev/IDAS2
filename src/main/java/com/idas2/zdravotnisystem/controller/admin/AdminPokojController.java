package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.NemocnicniPokojRepository;
import com.idas2.zdravotnisystem.db.view.NemocnicniPokojView;
import com.idas2.zdravotnisystem.form.mistnost.pokoj.PokojCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.pokoj.PokojUpdateForm;
import com.idas2.zdravotnisystem.service.form.PokojFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/mistnost/pokoj")
public class AdminPokojController {

    private final PokojFormService pokojFormService;
    private final NemocnicniPokojRepository nemocnicniPokojRepository;

    @Autowired
    public AdminPokojController(
        PokojFormService pokojFormService,
        NemocnicniPokojRepository nemocnicniPokojRepository
    ) {
        this.pokojFormService = pokojFormService;
        this.nemocnicniPokojRepository = nemocnicniPokojRepository;
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
            .addObject("form", new PokojCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @ModelAttribute("form") PokojCreateForm form
    ) {
        pokojFormService.create(form);
        return RedirectUtil.redirect("/admin/mistnost/pokoj");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(
        @PathVariable("id")  Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        NemocnicniPokojView view = nemocnicniPokojRepository.findById(id);
        return new ModelAndView("admin/overview/pokoj/update")
            .addObject("form", pokojFormService.buildUpdateForm(view));
    }

    @PostMapping("/update")
    public ModelAndView update(
        @ModelAttribute("form") PokojUpdateForm form,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        pokojFormService.update(form);
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
