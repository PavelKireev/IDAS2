package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.LekarRepository;
import com.idas2.zdravotnisystem.db.view.LekarView;
import com.idas2.zdravotnisystem.form.LekarProfileUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lekar/profile")
public class LekarProfileController {

    private final LekarRepository lekarRepository;

    @Autowired
    public LekarProfileController(
        LekarRepository lekarRepository
    ) {
        this.lekarRepository = lekarRepository;
    }

    @GetMapping("/info")
    public ModelAndView info(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        LekarView lekarView =
            lekarRepository.getViewById(authUser.getUser().getId());

        return new ModelAndView("/lekar/profile")
            .addObject("lekarView", lekarView);
    }

    @PostMapping("/update")
    public ModelAndView update(
        @AuthenticationPrincipal AuthUser authUser,
        @ModelAttribute LekarProfileUpdateForm form
    ) {

        return new ModelAndView();
    }
}
