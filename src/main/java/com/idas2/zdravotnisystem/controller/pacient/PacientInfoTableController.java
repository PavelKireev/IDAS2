package com.idas2.zdravotnisystem.controller.pacient;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.HospitalizaceRepository;
import com.idas2.zdravotnisystem.db.repository.ProceduraRepository;
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
@RequestMapping("/pacient/info")
public class PacientInfoTableController {

    private final ProceduraRepository proceduraRepository;
    private final HospitalizaceRepository hospitalizaceRepository;

    @Autowired
    public PacientInfoTableController(
        ProceduraRepository proceduraRepository,
        HospitalizaceRepository hospitalizaceRepository
    ) {
        this.proceduraRepository = proceduraRepository;
        this.hospitalizaceRepository = hospitalizaceRepository;
    }

    @GetMapping("/procedury/nadchazejici")
    public ModelAndView nadchazejiciProcedury(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<ProceduraView> list =
            proceduraRepository.getProceduraViewListByUserIdAfterNow(authUser.getUser().getId());

        return new ModelAndView("pacient/appointments")
            .addObject("list", list);
    }

    @GetMapping("/procedury/minule")
    public ModelAndView minuleProcedury(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<ProceduraView> list =
            proceduraRepository.getProceduraViewListByUserIdBeforeNow(authUser.getUser().getId());

        return new ModelAndView("pacient/appointments")
            .addObject("list", list);
    }

    @GetMapping("/hospitalizace")
    public ModelAndView hospitalizaceList(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<HospitalizaceView> list =
            hospitalizaceRepository.findAllByPacientId(authUser.getUser().getId());

        return new ModelAndView("pacient/hospitalizace")
            .addObject("list", list);
    }
}
