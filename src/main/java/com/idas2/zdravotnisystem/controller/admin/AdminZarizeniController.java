package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.db.entity.Zarizeni;
import com.idas2.zdravotnisystem.db.repository.ZarizeniRepository;
import com.idas2.zdravotnisystem.db.view.ZarizeniView;
import com.idas2.zdravotnisystem.form.zarizeni.ZarizeniCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class AdminZarizeniController {

    private final ZarizeniRepository zarizeniRepository;

    @Autowired
    public AdminZarizeniController(
        ZarizeniRepository zarizeniRepository
    ) {
        this.zarizeniRepository = zarizeniRepository;
    }

    @GetMapping("")
    public ModelAndView list() {
        List<ZarizeniView> list = zarizeniRepository.findAllView();
        return new ModelAndView("admin/overview/zarizeni/list")
            .addObject("list", list);
    }

    @GetMapping("/create")
    public ModelAndView create(
    ) {
        return new ModelAndView()
            .addObject("form", new ZarizeniCreateForm());
    }

}
