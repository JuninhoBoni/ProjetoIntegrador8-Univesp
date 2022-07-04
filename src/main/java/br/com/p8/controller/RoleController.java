package br.com.p8.controller;

import br.com.p8.model.Role;
import br.com.p8.model.User;
import br.com.p8.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView("role/list");
        mv.addObject("profiles", roleService.findAll());
        mv.addObject("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView save(Role role){
        ModelAndView mv = new ModelAndView("role/add");
        mv.addObject("role", role);
        mv.addObject("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView save(Role role, BindingResult result){
        if(result.hasErrors()) {
            return save(role);
        }
        roleService.save(role);
        return findAll();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("role/delete");
        Role role = roleService.findById(id);
        mv.addObject("role", role);
        mv.addObject("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return mv;
    }

    @PostMapping("/delete")
    public ModelAndView delete(User user, BindingResult result){
        if(result.hasErrors()) {
            return delete(user.getId());
        }
        roleService.deleteById(user.getId());
        return findAll();
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("role/edit");
        Role role = roleService.findById(id);
        mv.addObject("role", role);
        mv.addObject("profiles", roleService.findAll());
        mv.addObject("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return mv;
    }

    @PostMapping("/edit")
    public ModelAndView edit(Role role, BindingResult result){
        if(result.hasErrors()) {
            return edit(role.getId());
        }
        roleService.save(role);
        return findAll();
    }
}
