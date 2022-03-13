package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.TypProcedury;
import com.idas2.zdravotnisystem.db.entity.Zarizeni;
import com.idas2.zdravotnisystem.db.repository.*;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import com.idas2.zdravotnisystem.db.view.LekarView;
import com.idas2.zdravotnisystem.db.view.ProceduraView;
import com.idas2.zdravotnisystem.form.procedura.ProceduraCreateForm;
import com.idas2.zdravotnisystem.form.procedura.ProceduraUpdateForm;
import com.idas2.zdravotnisystem.form.procedura.typ.ProceduraTypCreateForm;
import com.idas2.zdravotnisystem.form.procedura.typ.ProceduraTypUpdateForm;
import com.idas2.zdravotnisystem.service.form.ProceduraFormService;
import com.idas2.zdravotnisystem.service.form.ProceduraTypFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.procedura.ProceduraCreateFormValidator;
import com.idas2.zdravotnisystem.validator.procedura.ProceduraUpdateFormValidator;
import com.idas2.zdravotnisystem.validator.procedura.typ.ProceduraTypCreateFormValidator;
import com.idas2.zdravotnisystem.validator.procedura.typ.ProceduraTypUpdateFormValidator;
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
@RequestMapping("/admin/procedura")
public class AdminProceduraController {

    private final LekarRepository lekarRepository;
    private final ZarizeniRepository zarizeniRepository;
    private final ProceduraRepository proceduraRepository;
    private final ProceduraFormService proceduraFormService;
    private final TypProceduryRepository typProceduryRepository;
    private final HospitalizaceRepository hospitalizaceRepository;

    private final ProceduraCreateFormValidator proceduraCreateFormValidator;
    private final ProceduraUpdateFormValidator proceduraUpdateFormValidator;
    private final ProceduraTypCreateFormValidator proceduraTypCreateFormValidator;
    private final ProceduraTypUpdateFormValidator proceduraTypUpdateFormValidator;

    private final ProceduraTypFormService proceduraTypFormService;

    @Autowired
    public AdminProceduraController(
        LekarRepository lekarRepository,
        ZarizeniRepository zarizeniRepository,
        ProceduraRepository proceduraRepository,
        ProceduraFormService proceduraFormService,
        TypProceduryRepository typProceduryRepository,
        ProceduraTypFormService proceduraTypFormService,
        HospitalizaceRepository hospitalizaceRepository,
        ProceduraCreateFormValidator proceduraCreateFormValidator,
        ProceduraUpdateFormValidator proceduraUpdateFormValidator,
        ProceduraTypCreateFormValidator proceduraTypCreateFormValidator,
        ProceduraTypUpdateFormValidator proceduraTypUpdateFormValidator
    ) {
        this.lekarRepository = lekarRepository;
        this.typProceduryRepository = typProceduryRepository;
        this.hospitalizaceRepository = hospitalizaceRepository;
        this.zarizeniRepository = zarizeniRepository;
        this.proceduraRepository = proceduraRepository;
        this.proceduraFormService = proceduraFormService;
        this.proceduraCreateFormValidator = proceduraCreateFormValidator;
        this.proceduraUpdateFormValidator = proceduraUpdateFormValidator;
        this.proceduraTypCreateFormValidator = proceduraTypCreateFormValidator;
        this.proceduraTypUpdateFormValidator = proceduraTypUpdateFormValidator;
        this.proceduraTypFormService = proceduraTypFormService;
    }

    @InitBinder("createForm")
    protected void initCreateBinder(WebDataBinder binder) {
        binder.addValidators(proceduraCreateFormValidator);
    }

    @InitBinder("updateForm")
    protected void initUpdateBinder(WebDataBinder binder) {
        binder.addValidators(proceduraUpdateFormValidator);
    }

    @InitBinder("typCreateForm")
    protected void initTypCreateBinder(WebDataBinder binder) {
        binder.addValidators(proceduraTypCreateFormValidator);
    }

    @InitBinder("typUpdateTypForm")
    protected void initTypUpdateBinder(WebDataBinder binder) {
        binder.addValidators(proceduraTypUpdateFormValidator);
    }


    @GetMapping("")
    public ModelAndView list(
    ) {
        List<ProceduraView> list = proceduraRepository.findAll();

        return new ModelAndView("admin/overview/procedura/list")
            .addObject("list", list);
    }

    @GetMapping("/create")
    public ModelAndView create(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<LekarView> lekarList = lekarRepository.findAllView();
        List<Zarizeni> zarizeniList = zarizeniRepository.findAll();
        List<TypProcedury> typProceduryList = typProceduryRepository.findAll();
        List<HospitalizaceView> hospitalizaceList = hospitalizaceRepository.findAll();

        return new ModelAndView("admin/overview/procedura/create")
            .addObject("authUser", authUser)
            .addObject("lekarList", lekarList)
            .addObject("zarizeniList", zarizeniList)
            .addObject("createForm", new ProceduraCreateForm())
            .addObject("typProceduryList", typProceduryList)
            .addObject("hospitalizaceList", hospitalizaceList);
    }

    @PostMapping("/save")
    public ModelAndView save(
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("createForm") ProceduraCreateForm createForm,
        BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){
            List<LekarView> lekarList = lekarRepository.findAllView();
            List<Zarizeni> zarizeniList = zarizeniRepository.findAll();
            List<TypProcedury> typProceduryList = typProceduryRepository.findAll();
            List<HospitalizaceView> hospitalizaceList = hospitalizaceRepository.findAll();

            return new ModelAndView("admin/overview/procedura/create")
                .addObject("authUser", authUser)
                .addObject("lekarList", lekarList)
                .addObject("zarizeniList", zarizeniList)
                .addObject("createForm", createForm)
                .addObject("typProceduryList", typProceduryList)
                .addObject("hospitalizaceList", hospitalizaceList);
        }

        proceduraFormService.createAdmin(createForm);
        return RedirectUtil.redirect("/admin/procedura");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        ProceduraView view =
            proceduraRepository.findOne(id);

        List<LekarView> lekarList = lekarRepository.findAllView();
        List<Zarizeni> zarizeniList = zarizeniRepository.findAll();
        List<TypProcedury> typProceduryList = typProceduryRepository.findAll();
        List<HospitalizaceView> hospitalizaceList = hospitalizaceRepository.findAll();


        return new ModelAndView("/admin/overview/procedura/edit")
            .addObject("id", id)
            .addObject("authUser", authUser)
            .addObject("lekarList", lekarList)
            .addObject("zarizeniList", zarizeniList)
            .addObject("typProceduryList", typProceduryList)
            .addObject("hospitalizaceList", hospitalizaceList)
            .addObject("updateForm", proceduraFormService.buildUpdateForm(view));
    }

    @PostMapping("/{id}/update")
    public ModelAndView update(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("updateForm") ProceduraUpdateForm updateForm,
        BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){

            List<LekarView> lekarList = lekarRepository.findAllView();
            List<Zarizeni> zarizeniList = zarizeniRepository.findAll();
            List<TypProcedury> typProceduryList = typProceduryRepository.findAll();
            List<HospitalizaceView> hospitalizaceList = hospitalizaceRepository.findAll();


            return new ModelAndView("/admin/overview/procedura/edit")
                .addObject("id", id)
                .addObject("authUser", authUser)
                .addObject("lekarList", lekarList)
                .addObject("zarizeniList", zarizeniList)
                .addObject("typProceduryList", typProceduryList)
                .addObject("hospitalizaceList", hospitalizaceList)
                .addObject("updateForm", updateForm);
        }

        updateForm.setId(id);
        proceduraFormService.update(updateForm);
        return RedirectUtil.redirect("/admin/procedura");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        proceduraRepository.delete(id);
        return RedirectUtil.redirect("/admin/procedura");
    }

    @GetMapping("/typ")
    public ModelAndView typList() {
        List<TypProcedury> list = typProceduryRepository.findAll();
        return new ModelAndView("/admin/overview/procedura/typ/list")
            .addObject("list", list);
    }

    @GetMapping("/typ/create")
    public ModelAndView typCreate() {
        return new ModelAndView("/admin/overview/procedura/typ/create")
            .addObject("typCreateForm", new ProceduraTypCreateForm());
    }

    @PostMapping("/typ/save")
    public ModelAndView typSave(
        @Validated @ModelAttribute("typCreateForm") ProceduraTypCreateForm typCreateForm
    ) {
        proceduraTypFormService.create(typCreateForm);
        return RedirectUtil.redirect("/admin/procedura/typ");
    }

    @GetMapping("/typ/{id}/edit")
    public ModelAndView typEdit(
        @PathVariable Integer id
    ) {
        return new ModelAndView("/admin/overview/procedura/typ/edit")
            .addObject("id", id)
            .addObject(
                "typUpdateForm",
                proceduraTypFormService.buildUpdateForm(
                    typProceduryRepository.getOne(id))
            );
    }

    @PostMapping("/typ/{id}/update")
    public ModelAndView update(
        @PathVariable Integer id,
        @Validated @ModelAttribute("typUpdateForm") ProceduraTypUpdateForm typUpdateForm,
        BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("/admin/overview/procedura/typ/edit")
                .addObject("id", id)
                .addObject("typUpdateForm", typUpdateForm);
        }

        typUpdateForm.setId(id);
        proceduraTypFormService.update(typUpdateForm);
        return RedirectUtil.redirect("/admin/procedura/typ");
    }

    @GetMapping("/typ/{id}/delete")
    public ModelAndView delete(
        @PathVariable Integer id
    ) {
        typProceduryRepository.delete(id);
        return RedirectUtil.redirect("/admin/procedura/typ");
    }


}
