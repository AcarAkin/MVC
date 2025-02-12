package com.works.controllers;

import com.works.entities.Product;
import com.works.services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {

    final ProductService pService;

    public DashboardController(ProductService pService) {
        this.pService = pService;
    }

    String deleteStatus = "";
    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("ls",pService.list());
        model.addAttribute("deleteStatus",deleteStatus);
        deleteStatus ="";
        return "dashboard";
    }


    @PostMapping("/productSave")
    public String productSave(Product product){
        pService.save(product);
        return "redirect:/dashboard";
    }

    @GetMapping("/productDelete/{pid}")
    public String productDelete(@PathVariable int pid) {
        pService.delete( pid );
        deleteStatus = "Delete Product: " + pid;
        return "redirect:/dashboard";

}

}
