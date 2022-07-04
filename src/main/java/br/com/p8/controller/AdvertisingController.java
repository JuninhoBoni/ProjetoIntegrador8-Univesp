package br.com.p8.controller;

import br.com.p8.model.Advertising;
import br.com.p8.service.AdvertisingService;
import br.com.p8.service.RoleService;
import br.com.p8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping(value = "/advertising")
public class AdvertisingController {

    @Autowired
    private AdvertisingService advertisingService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("advertising/list");
        mv.addObject("advertisings", advertisingService.findAll());
        mv.addObject("agentName", userService.findAll());
        mv.addObject("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView save(Advertising advertising) {
        ModelAndView mv = new ModelAndView("advertising/add");
        mv.addObject("advertisings", advertising);
        mv.addObject("users", userService.findAllMunicipes());
        mv.addObject("agents", userService.findAllAgentes());
        mv.addObject("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView save(Advertising advertising, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return save(advertising);
        }
        advertisingService.save(advertising);
        return findAll();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("advertising/delete");
        Advertising advertising = advertisingService.findById(id);
        mv.addObject("advertising", advertising);
        mv.addObject("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return mv;
    }

    @PostMapping("/delete")
    public ModelAndView delete(Advertising advertising, BindingResult result){
        if(result.hasErrors()) {
            return delete(advertising.getId());
        }
        advertisingService.deleteById(advertising.getId());
        return findAll();
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("advertising/edit");
        Advertising advertising = advertisingService.findById(id);
        mv.addObject("advertising", advertising);
        mv.addObject("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return mv;
    }

    @PostMapping("/edit")
    public ModelAndView edit(Advertising advertising, BindingResult result) {
        if (result.hasErrors()) {
            return edit(advertising.getId());
        }
        advertisingService.save(advertising);
        return findAll();
    }
}
