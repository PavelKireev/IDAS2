package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.OrdinaceRepository;
import com.idas2.zdravotnisystem.db.view.OrdinaceView;
import com.idas2.zdravotnisystem.form.mistnost.ordinace.OrdinaceCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.ordinace.OrdinaceUpdateForm;
import com.idas2.zdravotnisystem.service.form.OrdinaceFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/mistnost/ordinace")
public class AdminOrdinaceController {

    private final OrdinaceRepository ordinaceRepository;
    private final OrdinaceFormService ordinaceFormService;

    @Autowired
    public AdminOrdinaceController(
        OrdinaceRepository ordinaceRepository,
        OrdinaceFormService ordinaceFormService
    ) {
        this.ordinaceRepository = ordinaceRepository;
        this.ordinaceFormService = ordinaceFormService;
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
        @ModelAttribute OrdinaceCreateForm form
    ) {
        ordinaceFormService.create(form);
        return RedirectUtil.redirect("/admin/mistnost/ordinace");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        OrdinaceView view = ordinaceRepository.findById(id);

        return new ModelAndView("admin/overview/ordinace/edit")
            .addObject("form", ordinaceFormService.buildUpdateForm(view));
    }

    @PostMapping("/{kancelarId}/update")
    public ModelAndView update(
        @PathVariable Integer kancelarId,
        @ModelAttribute OrdinaceUpdateForm form
    ) {
        form.setId(kancelarId);
        ordinaceFormService.update(form);
        return RedirectUtil.redirect("/admin/mistnost/ordinace");
    }

    @GetMapping("{kancelarId}/delete")
    public ModelAndView delete(
        @PathVariable Integer kancelarId
    ) {
        ordinaceRepository.delete(kancelarId);
        return RedirectUtil.redirect("/admin/mistnost/ordinace");
    }
}
