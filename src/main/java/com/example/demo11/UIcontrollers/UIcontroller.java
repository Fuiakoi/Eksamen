package com.example.demo11.UIcontrollers;

import DBcontroller.DBSQL;
import Entities.Admin;
import UseCases.UseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class UIcontroller {

    @GetMapping("/index")
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @PostMapping("/index")
    public String login(@RequestParam String email, @RequestParam String password, Model model) throws SQLException {
        System.out.println("Login attempt with email: " + email);
       /* UseCase useCase = new UseCase();
        useCase.loginCheck();*/
        Admin admin = DBSQL.getAdmin(email);
        if (admin != null) {
            System.out.println("Found admin with email: " + admin.getEmail());
            if (admin.getPassword().equals(password)) {
                System.out.println("Password matched. Redirecting to admin.");
                return "admin";
            }
        }
        else {
            System.out.println("Login failed. Invalid email or password.");
            model.addAttribute("error", "Invalid email or password.");
            return "index";
        }
        return null;
    }


    @PostMapping("/admin")
    public String admin() {
        return "admin";
    }
}