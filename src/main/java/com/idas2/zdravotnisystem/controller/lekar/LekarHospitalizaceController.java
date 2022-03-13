package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.HospitalizaceRepository;
import com.idas2.zdravotnisystem.db.repository.ZaznamRepository;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import com.idas2.zdravotnisystem.db.view.ZaznamView;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarZaznamForm;
import com.idas2.zdravotnisystem.service.form.LekarHospitalizaceFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import com.idas2.zdravotnisystem.validator.hospitalizace.HospitalizaceCreateFormValidator;
import com.idas2.zdravotnisystem.validator.hospitalizace.HospitalizaceUpdateFormValidator;
import com.idas2.zdravotnisystem.validator.hospitalizace.zaznam.ZaznamCreateFormValidator;
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
@RequestMapping("lekar/hospitalizace")
public class LekarHospitalizaceController {

    private final ZaznamRepository zaznamRepository;
    private final HospitalizaceRepository hospitalizaceRepository;
    private final LekarHospitalizaceFormService lekarHospitalizaceFormService;

    private final ZaznamCreateFormValidator zaznamCreateFormValidator;

    @Autowired
    public LekarHospitalizaceController(
        ZaznamRepository zaznamRepository,
        HospitalizaceRepository hospitalizaceRepository,
        LekarHospitalizaceFormService lekarHospitalizaceFormService,
        ZaznamCreateFormValidator zaznamCreateFormValidator
    ) {
        this.zaznamRepository = zaznamRepository;
        this.hospitalizaceRepository = hospitalizaceRepository;
        this.lekarHospitalizaceFormService = lekarHospitalizaceFormService;
        this.zaznamCreateFormValidator = zaznamCreateFormValidator;
    }

    @InitBinder("zaznamCreateForm")
    protected void initZaznamCreateBinder(WebDataBinder binder) {
        binder.addValidators(zaznamCreateFormValidator);
    }

    @GetMapping("/list")
    public ModelAndView list(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<HospitalizaceView> list =
            hospitalizaceRepository.findAll();

        return new ModelAndView("lekar/hospitalizace/list")
            .addObject("authUser", authUser)
            .addObject("list", list);
    }

    @GetMapping("/add")
    public ModelAndView hospitalizaceAdd(
        @AuthenticationPrincipal AuthUser authUser
    ){
        return new ModelAndView();
    }

    @GetMapping("/zaznam")
    public ModelAndView addZaznam(
        @RequestParam Integer hospId,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        LekarZaznamForm zaznamCreateForm = new LekarZaznamForm();

        zaznamCreateForm
            .setIdLekar(authUser.getUser().getId())
            .setIdHospitalizace(hospId);

        return new ModelAndView("lekar/hospitalizace/zaznam/create")
            .addObject("zaznamCreateForm", zaznamCreateForm)
            .addObject("hospId", hospId)
            .addObject("authUser", authUser);

    }

    @PostMapping("/zaznam/create")
    public ModelAndView createZaznam(
        @RequestParam Integer hospId,
        @AuthenticationPrincipal AuthUser authUser,
        @Validated @ModelAttribute("zaznamCreateForm") LekarZaznamForm zaznamCreateForm,
        BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){
            zaznamCreateForm
                .setIdLekar(authUser.getUser().getId())
                .setIdHospitalizace(hospId);

            return new ModelAndView("lekar/hospitalizace/zaznam/create")
                .addObject("zaznamCreateForm", zaznamCreateForm)
                .addObject("hospId", hospId)
                .addObject("authUser", authUser);
        }

        zaznamCreateForm
            .setIdHospitalizace(hospId)
            .setIdLekar(authUser.getUser().getId());

        lekarHospitalizaceFormService.createZaznam(zaznamCreateForm);

        return RedirectUtil.redirect(
            String.format("/lekar/hospitalizace/zaznam/list?hospId=%s", hospId)
        );
    }


    @GetMapping("/zaznam/list")
    public ModelAndView zaznamList(
        @RequestParam Integer hospId,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<ZaznamView> zaznamList =
            zaznamRepository.findAllByHospitalizaceId(hospId);

        return new ModelAndView("lekar/hospitalizace/zaznam/list")
            .addObject("hospId", hospId)
            .addObject("list", zaznamList)
            .addObject("authUser", authUser);
    }

    @GetMapping("/zaznam/delete")
    public ModelAndView zaznamList(
        @RequestParam Integer zazId,
        @RequestParam Integer hospId
    ) {
        zaznamRepository.delete(zazId);

        return RedirectUtil.redirect(
            String.format("/lekar/hospitalizace/zaznam/list?hospId=%s", hospId)
        );
    }
}
