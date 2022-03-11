package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.db.entity.TypZarizeni;
import com.idas2.zdravotnisystem.db.repository.OrdinaceRepository;
import com.idas2.zdravotnisystem.db.repository.TypZarizeniRepository;
import com.idas2.zdravotnisystem.db.repository.ZarizeniRepository;
import com.idas2.zdravotnisystem.db.view.OrdinaceView;
import com.idas2.zdravotnisystem.db.view.ZarizeniView;
import com.idas2.zdravotnisystem.form.zarizeni.TypZarizeniCreateForm;
import com.idas2.zdravotnisystem.form.zarizeni.TypZarizeniUpdateForm;
import com.idas2.zdravotnisystem.form.zarizeni.ZarizeniCreateForm;
import com.idas2.zdravotnisystem.form.zarizeni.ZarizeniUpdateForm;
import com.idas2.zdravotnisystem.service.form.ZarizeniFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.zarizeni.ZarizeniCreateFormValidator;
import com.idas2.zdravotnisystem.validator.zarizeni.ZarizeniUpdateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/zarizeni")
public class AdminZarizeniController {

    private final ZarizeniRepository zarizeniRepository;
    private final OrdinaceRepository ordinaceRepository;
    private final ZarizeniFormService zarizeniFormService;
    private final TypZarizeniRepository typZarizeniRepository;

    private final ZarizeniCreateFormValidator zarizeniCreateFormValidator;
    private final ZarizeniUpdateFormValidator zarizeniUpdateFormValidator;

    @Autowired
    public AdminZarizeniController(
        ZarizeniRepository zarizeniRepository,
        OrdinaceRepository ordinaceRepository,
        ZarizeniFormService zarizeniFormService,
        TypZarizeniRepository typZarizeniRepository,
        ZarizeniCreateFormValidator zarizeniCreateFormValidator,
        ZarizeniUpdateFormValidator zarizeniUpdateFormValidator
    ) {
        this.zarizeniRepository = zarizeniRepository;
        this.ordinaceRepository = ordinaceRepository;
        this.zarizeniFormService = zarizeniFormService;
        this.typZarizeniRepository = typZarizeniRepository;
        this.zarizeniCreateFormValidator = zarizeniCreateFormValidator;
        this.zarizeniUpdateFormValidator = zarizeniUpdateFormValidator;
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
        List<OrdinaceView> ordinaceList = ordinaceRepository.findAll();
        List<TypZarizeni> typZarizeniList = typZarizeniRepository.findAll();

        return new ModelAndView("/admin/overview/zarizeni/create")
            .addObject("ordinaceList", ordinaceList)
            .addObject("form", new ZarizeniCreateForm())
            .addObject("typZarizeniList", typZarizeniList);
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
    ) {
        ZarizeniView view = zarizeniRepository.getOne(id);

        List<OrdinaceView> ordinaceList = ordinaceRepository.findAll();
        List<TypZarizeni> typZarizeniList = typZarizeniRepository.findAll();

        return new ModelAndView("/admin/overview/zarizeni/edit")
            .addObject("id", id)
            .addObject("ordinaceList", ordinaceList)
            .addObject("typZarizeniList", typZarizeniList)
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

    @GetMapping("/typ")
    public ModelAndView typList() {

        List<TypZarizeni> list = typZarizeniRepository.findAll();

        return new ModelAndView("/admin/overview/zarizeni/typ/list")
            .addObject("list", list);
    }

    @GetMapping("/typ/create")
    public ModelAndView typCreate(
    ) {
        return new ModelAndView("/admin/overview/zarizeni/typ/create")
            .addObject("form", new TypZarizeniCreateForm());
    }

    @PostMapping("/typ/save")
    public ModelAndView typSave(
        @ModelAttribute TypZarizeniCreateForm form
    ) {
        zarizeniFormService.createTyp(form);
        return RedirectUtil.redirect("/admin/zarizeni/typ");
    }

    @GetMapping("/typ/{id}/edit")
    public ModelAndView typEdit(
        @PathVariable Integer id
    ) {
        TypZarizeni entity = typZarizeniRepository.getOne(id);
        return new ModelAndView("/admin/overview/zarizeni/typ/edit")
            .addObject("form", zarizeniFormService.buildUpdateTypForm(entity));
    }

    @PostMapping("/typ/{id}/update")
    public ModelAndView typUpdate(
        @PathVariable Integer id,
        @ModelAttribute TypZarizeniUpdateForm form
    ) {
        form.setId(id);
        zarizeniFormService.updateTyp(form);
        return RedirectUtil.redirect("/admin/zarizeni/typ");
    }

    @GetMapping("/typ/{id}/delete")
    public ModelAndView typDelete(
        @PathVariable Integer id
    ) {
        typZarizeniRepository.delete(id);
        return RedirectUtil.redirect("/admin/zarizeni/typ");
    }

}
