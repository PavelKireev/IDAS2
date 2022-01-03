package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.Log;
import com.idas2.zdravotnisystem.db.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final LogRepository logRepositozry;

    @Autowired
    public AdminController(
        LogRepository logRepositozry
    ) {
        this.logRepositozry = logRepositozry;
    }

    @GetMapping("/log")
    public ModelAndView log(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        List<Log> list = logRepositozry.findAll();

        return new ModelAndView("/admin/log")
            .addObject("list", list);
    }

    @GetMapping("/overview")
    public ModelAndView overview(){

        List<String> list = new ArrayList<>();

        list.add("ADMINISTRATOR");
        list.add("HOSPITALIZACE");
        list.add("KANCELAR");
        list.add("LEKAR");
        list.add("LOG");
        list.add("MISTNOST");
        list.add("NEMOCNICNI_POKOJ");
        list.add("OBRAZEK");
        list.add("ODEBRANY_UZIVATEL");
        list.add("ORDINACE");
        list.add("PACIENT");
        list.add("POJISTENI");
        list.add("POJISTOVNA");
        list.add("PROCEDURA");
        list.add("SPECIALIZACE");
        list.add("TYP_PROCEDURY");
        list.add("TYP_ZARIZENI");
        list.add("ZARIZENI");
        list.add("ZAZNAM");
        list.add("ZDRAVOTNI_KARTA");

        return new ModelAndView("/main/resources/templates/admin/overview/overview.ftlh")
            .addObject("list", list);
    }

}
