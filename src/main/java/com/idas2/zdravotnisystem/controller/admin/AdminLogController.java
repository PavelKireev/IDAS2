package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.db.entity.Log;
import com.idas2.zdravotnisystem.db.repository.LogRepository;
import com.idas2.zdravotnisystem.db.view.LogTabulkyView;
import com.idas2.zdravotnisystem.db.view.LogUzivatelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/log")
public class AdminLogController {

    private final LogRepository logRepository;

    @Autowired
    public AdminLogController(
        LogRepository logRepository
    ) {
        this.logRepository = logRepository;
    }

    @GetMapping("/uzivatele")
    public ModelAndView uzivatele(
    ) {
        List<LogUzivatelView> list = logRepository.findAllUserLog();

        return new ModelAndView("/admin/log/users")
            .addObject("list", list);
    }

    @GetMapping("/tabulky")
    public ModelAndView tabulky(
    ) {
        List<LogTabulkyView> list = logRepository.findAllTableLog();

        return new ModelAndView("/admin/log/tables")
            .addObject("list", list);    }
}
