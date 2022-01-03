package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.db.entity.Pacient;
import com.idas2.zdravotnisystem.db.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/table/PACIENT")
public class AdminPacientController {

    private final PacientRepository repository;

    @Autowired
    public AdminPacientController(
        PacientRepository repository
    ) {
        this.repository = repository;
    }

    @GetMapping("/info")
    public ModelAndView info(
    ){
        List<Pacient> list = repository.findAll();
        return new ModelAndView("/admin/overview/pacient")
            .addObject("list", list);
    }

    @GetMapping("/create")
    public ModelAndView create(
    ){
        List<Pacient> list = repository.findAll();
        return new ModelAndView("/admin/overview/pacient")
            .addObject("list", list);
    }

    @GetMapping("/update")
    public ModelAndView update(
    ){
        List<Pacient> list = repository.findAll();
        return new ModelAndView("/admin/overview/pacient")
            .addObject("list", list);
    }

}
