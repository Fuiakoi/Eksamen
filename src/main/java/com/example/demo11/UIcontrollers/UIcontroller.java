package com.example.demo11.UIcontrollers;

import UseCases.UseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.SQLException;

@Controller
public class UIcontroller {

    @PostMapping("/index")
    public String index() {
        return "index";}

    @PostMapping("/register")
    public String register(@RequestParam String fname, @RequestParam String lname, @RequestParam String firm, @RequestParam String idType, Model model) throws SQLException {
        UseCase useCase = new UseCase();
        String res = useCase.buildEntry(fname, lname, firm, idType);
        return "register";}

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) throws SQLException {
        UseCase useCase = new UseCase();
        String res = useCase.loginCheck(email, password);
        if (res == "") {
            return "wrongmail";
        } else if (res == "Correct") {
            return "admin";
        } else
            return "wrongpassword";
    }

    @PostMapping("/newadmin")
    public String newAdmin() {
        return "newadmin";}

    @PostMapping("/deleteadmin")
    public String deleteAdmin() {
        return "deleteadmin";}

    @PostMapping("/listentry")
    public String listEntry() {
        return "listentry";}

    @PostMapping("/wrongmail")
    public String wrongEmail() {
        return "wrongmail";}

    @PostMapping("/wrongpassword")
    public String wrongPassword() {
        return "wrongpassword";}

    @PostMapping("/admin")
    public String admin() {
        return "admin";}

    @PostMapping("/admindeleted")
    public String adminDeleted() {
        return "admindeleted";}

    @PostMapping("/adminmade")
    public String adminMade() {
        return "adminmade";}
}