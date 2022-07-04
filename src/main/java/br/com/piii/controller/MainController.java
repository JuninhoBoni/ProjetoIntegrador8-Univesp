package br.com.piii.controller;

import br.com.piii.service.AdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    private AdvertisingService advertisingService;
    @GetMapping("/principal")
    public ModelAndView main(){
        ModelAndView mv = new ModelAndView("advertising/list");
        mv.addObject("advertisings", advertisingService.findAll());
        mv.addObject("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return mv;
    }
}
