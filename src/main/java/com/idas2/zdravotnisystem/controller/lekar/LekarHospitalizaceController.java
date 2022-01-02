package com.idas2.zdravotnisystem.controller.lekar;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.HospitalizaceRepository;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import com.idas2.zdravotnisystem.db.view.ProceduraView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("lekar/hospitalizace")
public class LekarHospitalizaceController {

    private final HospitalizaceRepository hospitalizaceRepository;

    @Autowired
    public LekarHospitalizaceController(
        HospitalizaceRepository hospitalizaceRepository
    ) {
        this.hospitalizaceRepository = hospitalizaceRepository;
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
}
