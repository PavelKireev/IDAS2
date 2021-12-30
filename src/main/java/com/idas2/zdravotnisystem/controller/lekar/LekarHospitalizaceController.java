package com.idas2.zdravotnisystem.controller.lekar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("lekar/hospitalizace")
public class LekarHospitalizaceController {

    @GetMapping("/list")
    public ModelAndView list(

    ){
        return new ModelAndView("/lekar/list");
    }
}
