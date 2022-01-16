package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.HospitalizaceRepository;
import com.idas2.zdravotnisystem.db.repository.ZaznamRepository;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import com.idas2.zdravotnisystem.db.view.ZaznamView;
import com.idas2.zdravotnisystem.form.lekar.LekarZaznamForm;
import com.idas2.zdravotnisystem.service.form.LekarHospitalizaceFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("lekar/hospitalizace")
public class LekarHospitalizaceController {

    private final ZaznamRepository zaznamRepository;
    private final HospitalizaceRepository hospitalizaceRepository;
    private final LekarHospitalizaceFormService lekarHospitalizaceFormService;

    @Autowired
    public LekarHospitalizaceController(
        ZaznamRepository zaznamRepository,
        HospitalizaceRepository hospitalizaceRepository,
        LekarHospitalizaceFormService lekarHospitalizaceFormService
    ) {
        this.zaznamRepository = zaznamRepository;
        this.hospitalizaceRepository = hospitalizaceRepository;
        this.lekarHospitalizaceFormService = lekarHospitalizaceFormService;
    }

    @GetMapping("/list")
    public ModelAndView list(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<HospitalizaceView> list =
            hospitalizaceRepository.findAll();

        return new ModelAndView("lekar/hospitalizace/list")
            .addObject("list", list);
    }

    @GetMapping("/zaznam")
    public ModelAndView addZaznam(
        @RequestParam Integer hospId,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        LekarZaznamForm form = new LekarZaznamForm();

        form
            .setIdLekar(authUser.getUser().getId())
            .setIdHospitalizace(hospId);

        return new ModelAndView("lekar/hospitalizace/zaznam/create")
            .addObject("form", form)
            .addObject("hospId", hospId);
    }

    @PostMapping("/zaznam/create")
    public ModelAndView createZaznam(
        @RequestParam Integer hospId,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("form") LekarZaznamForm form
    ) {
        form
            .setIdHospitalizace(hospId)
            .setIdLekar(authUser.getUser().getId());

        lekarHospitalizaceFormService.createZaznam(form);

        return RedirectUtil.redirect(
            String.format("/lekar/hospitalizace/zaznam/list?hospId=%s", hospId)
        );
    }


    @GetMapping("/zaznam/list")
    public ModelAndView zaznamList(
        @RequestParam Integer hospId
    ) {
        List<ZaznamView> zaznamList =
            zaznamRepository.findAllByHospitalizaceId(hospId);

        return new ModelAndView("lekar/hospitalizace/zaznam/list")
            .addObject("hospId", hospId)
            .addObject("list", zaznamList);
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
