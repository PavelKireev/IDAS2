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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
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

    @InitBinder("createForm")
    protected void initCreateBinder(WebDataBinder binder) {
        binder.addValidators(pojistovnaCreateFormValidator);
    }

    @InitBinder("updateForm")
    protected void initUpdateBinder(WebDataBinder binder) {
        binder.addValidators(pojistovnaUpdateFormValidator);
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
            .addObject("createForm", new PojistovnaCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @Validated @ModelAttribute("createForm") PojistovnaCreateForm createForm,
        BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("admin/overview/pojistovna/create")
                .addObject("createForm", createForm);
        }

        pojistovnaFormService.create(createForm);
        return RedirectUtil.redirect("/admin/pojistovna");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(
       @PathVariable Integer id
    ){
       Pojistovna pojistovna = pojistovnaRepository.getOne(id);

       return new ModelAndView("/admin/overview/pojistovna/edit")
           .addObject("id", id)
           .addObject("updateForm", pojistovnaFormService.buildUpdateForm(pojistovna));
    }

    @PostMapping("/{id}/update")
    public ModelAndView update(
        @PathVariable Integer id,
        @Validated @ModelAttribute("updateForm") PojistovnaUpdateForm updateForm,
        BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("/admin/overview/pojistovna/edit")
                .addObject("id", id)
                .addObject("updateForm", updateForm);
        }
        updateForm.setId(id);
        pojistovnaFormService.update(updateForm);
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
