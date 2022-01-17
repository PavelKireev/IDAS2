package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.UzivatelRepository;
import com.idas2.zdravotnisystem.util.RedirectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/lekar")
public class AdminLekarController {

    private final UzivatelRepository uzivatelRepository;

    @Autowired
    public AdminLekarController(
        UzivatelRepository uzivatelRepository
    ) {
        this.uzivatelRepository = uzivatelRepository;
    }

    @GetMapping("/{lekarId}/simulate")
    public ModelAndView simulate(
        @PathVariable Integer lekarId,
        @AuthenticationPrincipal AuthUser authUser
    ) {
        User user = uzivatelRepository.findById(lekarId);
        authUser.setAdminId(authUser.getUser().getId());
        authUser.setSimulated(true);
        authUser.setUser(user);

        return RedirectUtil.redirect("/lekar/profile/info");
    }

    @GetMapping("/unsimulate")
    public ModelAndView unsimulate(
        @RequestParam Integer admId,
        @AuthenticationPrincipal AuthUser authUser
    ) {

        User user = uzivatelRepository.findById(admId);

        authUser.setAdminId(0);
        authUser.setSimulated(false);
        authUser.setUser(user);

        return RedirectUtil.redirect("/admin/lekar/list");
    }
}
