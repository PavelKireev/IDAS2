package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.db.entity.Pacient;
import com.idas2.zdravotnisystem.db.repository.PacientRepository;
import com.idas2.zdravotnisystem.form.PacientInfoForm;
import com.idas2.zdravotnisystem.form.pacient.PacientCreateForm;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/table/PACIENT")
public class AdminPacientController {

    private final PacientRepository repository;

    @Autowired
    public AdminPacientController(
        PacientRepository repository
    ) {
        this.repository = repository;
    }

    @GetMapping("/info")
    public ModelAndView info(
    ) {
        List<Pacient> list = repository.findAll();
        return new ModelAndView("/admin/overview/pacient")
            .addObject("list", list);
    }

    @GetMapping("/create")
    public ModelAndView create(
    ) {
        PacientCreateForm pacientCreateForm = new PacientCreateForm();
        return new ModelAndView("/admin/overview/PACIENT/create")
            .addObject("pacientForm", pacientCreateForm);
    }

    @PostMapping("/save")
    public ModelAndView save(
        @ModelAttribute("pacientForm") PacientInfoForm pacientForm
    ) {

        return RedirectUtil.redirect("/admin/table/PACIENT/info");
    }

    @GetMapping("/update")
    public ModelAndView update(
    ) {
        List<Pacient> list = repository.findAll();
        return new ModelAndView("/admin/overview/pacient")
            .addObject("list", list);
    }

    @GetMapping("/{pacientId}/delete")
    public ModelAndView delete(
        @PathVariable Integer pacientId
    ) {
        repository.delete(pacientId);
        return RedirectUtil.redirect("/admin/table/PACIENT/info");
    }

}
