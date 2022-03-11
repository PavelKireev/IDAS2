package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import com.idas2.zdravotnisystem.db.repository.PojistovnaRepository;
import com.idas2.zdravotnisystem.form.pojistovna.PojistovnaCreateForm;
import com.idas2.zdravotnisystem.form.pojistovna.PojistovnaUpdateForm;
import com.idas2.zdravotnisystem.service.form.PojistovnaFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.pojistovna.PojistovnaCreateFormValidator;
import com.idas2.zdravotnisystem.validator.pojistovna.PojistovnaUpdateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/pojistovna")
public class AdminPojistovnaController {

    private final PojistovnaRepository pojistovnaRepository;
    private final PojistovnaFormService pojistovnaFormService;
    private final PojistovnaCreateFormValidator pojistovnaCreateFormValidator;
    private final PojistovnaUpdateFormValidator pojistovnaUpdateFormValidator;

    @Autowired
    public AdminPojistovnaController(
        PojistovnaRepository pojistovnaRepository,
        PojistovnaFormService pojistovnaFormService,
        PojistovnaCreateFormValidator pojistovnaCreateFormValidator,
        PojistovnaUpdateFormValidator pojistovnaUpdateFormValidator
    ) {
        this.pojistovnaRepository = pojistovnaRepository;
        this.pojistovnaFormService = pojistovnaFormService;
        this.pojistovnaCreateFormValidator = pojistovnaCreateFormValidator;
        this.pojistovnaUpdateFormValidator = pojistovnaUpdateFormValidator;
    }

    @GetMapping("")
    public ModelAndView list() {
        List<Pojistovna> list = pojistovnaRepository.findAll();
        return new ModelAndView("admin/overview/pojistovna/list")
            .addObject("list", list);
    }

    @GetMapping("/create")
    public ModelAndView create(
    ) {
        return new ModelAndView("admin/overview/pojistovna/create")
            .addObject("form", new PojistovnaCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @ModelAttribute PojistovnaCreateForm form
    ) {
        pojistovnaFormService.create(form);
        return RedirectUtil.redirect("/admin/pojistovna");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(
       @PathVariable Integer id
    ){
       Pojistovna pojistovna = pojistovnaRepository.getOne(id);

       return new ModelAndView("/admin/overview/pojistovna/edit")
           .addObject("id", id)
           .addObject("form", pojistovnaFormService.buildUpdateForm(pojistovna));
    }

    @PostMapping("/{id}/update")
    public ModelAndView update(
        @PathVariable Integer id,
        @ModelAttribute PojistovnaUpdateForm form
    ) {
        form.setId(id);
        pojistovnaFormService.update(form);
        return RedirectUtil.redirect("/admin/pojistovna");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(
        @PathVariable Integer id
    ) {
        pojistovnaRepository.delete(id);
        return RedirectUtil.redirect("/admin/pojistovna");
    }
}
