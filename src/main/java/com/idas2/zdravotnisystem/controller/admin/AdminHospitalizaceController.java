package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.HospitalizaceRepository;
import com.idas2.zdravotnisystem.db.repository.LekarRepository;
import com.idas2.zdravotnisystem.db.repository.PacientRepository;
import com.idas2.zdravotnisystem.db.repository.ZaznamRepository;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import com.idas2.zdravotnisystem.db.view.LekarView;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.db.view.ZaznamView;
import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceCreateForm;
import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceUpdateForm;
import com.idas2.zdravotnisystem.form.hospitalizace.zaznam.ZaznamCreateForm;
import com.idas2.zdravotnisystem.service.form.HospitalizaceFormService;
import com.idas2.zdravotnisystem.service.form.ZaznamFormService;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/hospitalizace")
public class AdminHospitalizaceController {

    private final LekarRepository lekarRepository;
    private final ZaznamRepository zaznamRepository;
    private final PacientRepository pacientRepository;
    private final ZaznamFormService zaznamFormService;
    private final HospitalizaceRepository hospitalizaceRepository;
    private final HospitalizaceFormService hospitalizaceFormService;

    @Autowired
    public AdminHospitalizaceController(
        LekarRepository lekarRepository,
        ZaznamRepository zaznamRepository,
        PacientRepository pacientRepository,
        ZaznamFormService zaznamFormService,
        HospitalizaceRepository hospitalizaceRepository,
        HospitalizaceFormService hospitalizaceFormService
    ) {
        this.lekarRepository = lekarRepository;
        this.zaznamRepository = zaznamRepository;
        this.pacientRepository = pacientRepository;
        this.zaznamFormService = zaznamFormService;
        this.hospitalizaceRepository = hospitalizaceRepository;
        this.hospitalizaceFormService = hospitalizaceFormService;
    }

    @GetMapping("")
    public ModelAndView list(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        return new ModelAndView("admin/overview/hospitalizace/list")
            .addObject("authUser", authUser)
            .addObject("list", hospitalizaceRepository.findAll());
    }

    @GetMapping("/create")
    public ModelAndView create(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<PacientView> pacientList = pacientRepository.findAllView();

        return new ModelAndView("admin/overview/hospitalizace/create")
            .addObject("authUser", authUser)
            .addObject("pacientList", pacientList)
            .addObject("form", new HospitalizaceCreateForm());
    }

    @PostMapping("/save")
    public ModelAndView save(
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("form") HospitalizaceCreateForm form
    ) {
        hospitalizaceFormService.create(form);
        return RedirectUtil.redirect("/admin/hospitalizace");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        HospitalizaceView view =
            hospitalizaceRepository.findOne(id);

        List<PacientView> pacientList = pacientRepository.findAllView();


        return new ModelAndView("/admin/overview/hospitalizace/edit")
            .addObject("authUser", authUser)
            .addObject("pacientList", pacientList)
            .addObject("id", view.getId())
            .addObject(
                "form",
                hospitalizaceFormService.buildUpdateForm(view)
            );
    }

    @PostMapping("/{id}/update")
    public ModelAndView update(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("form") HospitalizaceUpdateForm form
    ) {
        form.setId(id);
        hospitalizaceFormService.update(form);
        return RedirectUtil.redirect("/admin/hospitalizace");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        hospitalizaceRepository.delete(id);
        return RedirectUtil.redirect("/admin/hospitalizace");
    }

    @GetMapping("/{id}/zaznam")
    public ModelAndView zaznamList(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<ZaznamView> zaznamList =
            zaznamRepository.findAllByHospitalizaceId(id);

        return new ModelAndView("admin/overview/hospitalizace/zaznam/list")
            .addObject("hospId", id)
            .addObject("list", zaznamList)
            .addObject("authUser", authUser);
    }

    @GetMapping("{id}/zaznam/create")
    public ModelAndView createZaznam(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<LekarView> lekarList = lekarRepository.findAllView();

        return new ModelAndView("admin/overview/hospitalizace/zaznam/create")
            .addObject("hospId", id)
            .addObject("authUser", authUser)
            .addObject("lekarList", lekarList)
            .addObject("form", new ZaznamCreateForm());

    }

    @PostMapping("/{id}/zaznam/save")
    public ModelAndView saveZaznam(
        @PathVariable Integer id,
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute("form") ZaznamCreateForm form
    ) {
        form
            .setIdHospitalizace(id);

        zaznamFormService.create(form);

        return RedirectUtil.redirect(
            String.format("/admin/hospitalizace/%d/zaznam", id)
        );
    }

//    @GetMapping("/{hospId}/zaznam/{zazId}/edit")
//    public ModelAndView zaznamEdit(
//        @PathVariable Integer zazId,
//        @PathVariable Integer hospId,
//        @AuthenticationPrincipal AuthUser authUser
//    ) {
//        ZaznamView view = zaznamRepository.findById(zazId);
//        List<LekarView> lekarList = lekarRepository.findAllView();
//
//        return new ModelAndView("/admin/overview/hospitalizace/zaznam/edit")
//            .addObject("authUser", authUser)
//            .addObject("lekarList", lekarList)
//            .addObject(
//                "form",
//                zaznamFormService.buildUpdateForm(view)
//            );
//    }
//
//    @PostMapping("/{hospId}/zaznam/{zazId}/update")
//    public ModelAndView zaznamUpdate(
//        @PathVariable Integer hospId,
//        @PathVariable Integer zazId,
//        @AuthenticationPrincipal AuthUser authUser,
//        @ModelAttribute("form") ZaznamUpdateForm form
//    ) {
//        form
//            .setId(zazId)
//            .setIdHospitalizace(hospId);
//
//        zaznamFormService.update(form);
//
//        return RedirectUtil.redirect(
//            String.format(
//                "/admin/hospitalizace/%d/zaznam",
//                hospId
//            )
//        );
//    }


    @GetMapping("/{hospId}/zaznam/{zazId}/delete")
    public ModelAndView zaznamDelete(
        @PathVariable Integer zazId,
        @PathVariable Integer hospId
    ) {
        zaznamRepository.delete(zazId);

        return RedirectUtil.redirect(
            String.format(
                "/admin/hospitalizace/%d/zaznam",
                hospId
            )
        );
    }
}
