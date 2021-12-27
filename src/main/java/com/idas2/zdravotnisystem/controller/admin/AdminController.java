package com.idas2.zdravotnisystem.controller.admin;

import com.idas2.zdravotnisystem.component.dto.TableListComponent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

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
        list.add("UZIVATEL");
        list.add("ZARIZENI");
        list.add("ZAZNAM");
        list.add("ZDRAVOTNI_KARTA");

        return new ModelAndView("/admin/overview")
            .addObject("list", list);
    }
}
