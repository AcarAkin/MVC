package com.works.services;

import com.works.entities.Admin;
import com.works.repositories.AdminRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    final AdminRepository aRepo;
    final HttpServletRequest req;
    final HttpServletResponse res;
    public AdminService(AdminRepository aRepo, HttpServletRequest req, HttpServletResponse res){
        this.aRepo = aRepo;
        this.req = req;
        this.res = res;
    }

    public String login(Admin admin){
        Optional<Admin> optionalAdmin = aRepo.findByEmailEqualsIgnoreCaseAndPasswordEquals(admin.getEmail(), admin.getPassword());

        if(optionalAdmin.isPresent()){
            Admin adm = optionalAdmin.get();
            req.getSession().setAttribute("admin", adm);
            return "redirect:/dashboard";
        }else {
            return "redirect:/";
        }
    }

    public String logout() {
        req.getSession().removeAttribute("admin");
        req.changeSessionId();
        return "redirect:/";
    }





}
