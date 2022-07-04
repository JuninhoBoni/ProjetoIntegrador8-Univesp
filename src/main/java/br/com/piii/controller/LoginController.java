package br.com.piii.controller;

import br.com.piii.service.AdvertisingService;
import br.com.piii.service.UserService;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
class LoginController {
    @Autowired
    private AdvertisingService advertisingService;
    @Autowired
    private UserService userService;
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("advertising/list");
        mv.addObject("advertisings", advertisingService.findAll());
        mv.addObject("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return mv;
    }

    @GetMapping("/logout")
    public String logout() {
        return "login/logout";
    }

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }
}
