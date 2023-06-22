package com.example.demo11.UIcontrollers;

import Entities.Entry;
import UseCases.UseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

import static DBcontroller.DBSQL.listAccessByPeriod;

@Controller
public class UIcontroller {

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        List<String> firmNames = UseCase.getFirmNames();
        model.addAttribute("firmNames", firmNames);
        return "index";
    }

    @PostMapping("/register")
    public String register(@RequestParam String fname, @RequestParam String lname, @RequestParam String firm,
                           @RequestParam String idType, Model model) throws SQLException {
        UseCase useCase = new UseCase();
        String res = useCase.buildEntry(fname, lname, firm, idType);
        return "register";
    }

    @GetMapping("/wrongmail")
    public String wrongEmail() {
        return "wrongmail";
    }

    @GetMapping("/wrongpassword")
    public String wrongPassword() {
        return "wrongpassword";
    }

    @PostMapping("/userlogin")
    public String userLogin(@RequestParam String email, @RequestParam String password, Model model) throws SQLException {
        UseCase useCase = new UseCase();
        String res = useCase.userLoginCheck(email, password);
        if (res == "") {
            return "wrongmail";
        } else if (res == "Correct") {
            return "user";
        } else
            return "wrongpassword";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @PostMapping("/adminlogin")
    public String adminLogin(@RequestParam String email, @RequestParam String password, Model model) throws SQLException {
        UseCase useCase = new UseCase();
        String res = useCase.adminLoginCheck(email, password);
        if (res == "") {
            return "wrongmail";
        } else if (res == "Correct") {
            return "admin";
        } else
            return "wrongpassword";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/newuser")
    public String newUser() {
        return "newuser";
    }

    @PostMapping("/usermade")
    public String newUser(@RequestParam String email, @RequestParam String password, Model model) throws SQLException {
        UseCase useCase = new UseCase();
        String res = useCase.buildUser(email, password);
        if (res == "User made") {
            return "usermade";
        } else {
            return "userexists";
        }
    }

    @GetMapping("/usermade")
    public String userMade() {
        return "usermade";
    }

    @GetMapping("/deleteuser")
    public String deleteUser() {

        return "deleteuser";
    }

    @GetMapping("/userdeleted")
    public String userDeleted(@RequestParam String email, Model model) throws SQLException {
        System.out.println("ui ready");
        UseCase user = new UseCase();
        UseCase.deleteUser(email);
        return "userdeleted";
    }

    @GetMapping("/newadmin")
    public String newAdmin() {
        return "newadmin";
    }

    @PostMapping("/adminmade")
    public String adminMade(@RequestParam String email, @RequestParam String password, Model model) throws SQLException {
        UseCase useCase = new UseCase();
        String res = useCase.buildAdmin(email, password);
        if (res == "Admin made") {
            return "adminmade";
        } else {
            return "adminexists";
        }
    }

    @GetMapping("/adminexists")
    public String adminExists() {
        return "adminexists";
    }

    @GetMapping("/deleteadmin")
    public String deleteAdmin() {
        return "deleteadmin";
    }

    @GetMapping("/admindeleted")
    public String adminDeleted() {
        return "admindeleted";
    }

    @GetMapping("/insertfirm")
    public String insertFirm() {
        return "insertfirm";
    }

    @PostMapping("/firminserted")
    public String firmInserted(@RequestParam String firmName) {
        UseCase useCase = new UseCase();
        useCase.insertFirm(firmName);
        return "firminserted";
    }

    @GetMapping("/entry")
    public String entry(Model model) {
        List<Entry> accessByPeriod = UseCase.buildList();
        model.addAttribute("accessByPeriod", accessByPeriod);
        return "entry";
    }

    @GetMapping("/listentry")
    public String listEntry() {
        return "listentry";
    }
}