package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.db.repository.ZarizeniRepository;
import com.idas2.zdravotnisystem.db.view.ZarizeniView;
import com.idas2.zdravotnisystem.form.zarizeni.ZarizeniCreateForm;
import com.idas2.zdravotnisystem.form.zarizeni.ZarizeniUpdateForm;
import com.idas2.zdravotnisystem.service.form.ZarizeniFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/zarizeni")
public class AdminZarizeniController {

    private final ZarizeniRepository zarizeniRepository;
    private final ZarizeniFormService zarizeniFormService;

    @Autowired
    public AdminZarizeniController(
        ZarizeniRepository zarizeniRepository,
        ZarizeniFormService zarizeniFormService
    ) {
        this.zarizeniRepository = zarizeniRepository;
        this.zarizeniFormService = zarizeniFormService;
    }

    @GetMapping("")
    public ModelAndView list() {
        List<ZarizeniView> list = zarizeniRepository.findAllView();
        return new ModelAndView("admin/overview/zarizeni/list")
            .addObject("list", list);
    }

    @GetMapping("/create")
    public ModelAndView create(
    ) {
        return new ModelAndView()
            .addObject("form", new ZarizeniCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @ModelAttribute ZarizeniCreateForm form
    ) {
        zarizeniFormService.create(form);
        return RedirectUtil.redirect("/admin/zarizeni");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(
        @PathVariable Integer id
    ){
        ZarizeniView view = zarizeniRepository.getOne(id);
        return new ModelAndView("/admin/overview/zarizeni/edit")
            .addObject("form", zarizeniFormService.buildUpdateForm(view));
    }

    @PostMapping("/{id}/update")
    public ModelAndView update(
        @PathVariable Integer id,
        @ModelAttribute ZarizeniUpdateForm form
    ) {
        form.setId(id);
        zarizeniFormService.update(form);
        return RedirectUtil.redirect("/admin/zarizeni");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(
        @PathVariable Integer id
    ) {
        zarizeniRepository.delete(id);
        return RedirectUtil.redirect("/admin/zarizeni");
    }

}
