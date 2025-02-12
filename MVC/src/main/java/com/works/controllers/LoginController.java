package com.works.controllers;

import com.works.entities.Admin;
import com.works.services.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    final AdminService aService;
    public LoginController(AdminService aService) {
        this.aService = aService;
    }

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("data","Site Title Data");
        return "login";
    }

    @PostMapping("/login")
    public String login(Admin admin){
       return aService.login(admin);
    }

    @GetMapping("/logout")
    public String logout() {
        return aService.logout();
    }




}
