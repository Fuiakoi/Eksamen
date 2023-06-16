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

    @GetMapping("/index")
    public String index() {
        return "index";}

    @PostMapping("/register")
    public String register(@RequestParam String fname, @RequestParam String lname, @RequestParam String firm,
                           @RequestParam String idType/*, @RequestParam String pictureID*/, Model model) throws SQLException {
        UseCase useCase = new UseCase();
        String res = useCase.buildEntry(fname, lname, firm, idType/*, pictureID*/);
        return "register";}

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

    @PostMapping("/newuser")
    public String newUser(@RequestParam String email, @RequestParam String password, Model model) throws SQLException {
        UseCase useCase = new UseCase();
        String res = useCase.userLoginCheck(email, password);
        if (res == "") {
            return "wrongmail";
        } else if (res == "Correct") {
            return "user";
        } else
            return "wrongpassword";
    }

    @GetMapping("/newadmin")
    public String newAdmin() {
        return "newadmin";}

    @GetMapping("/deleteadmin")
    public String deleteAdmin() {
        return "deleteadmin";}

    @GetMapping("/listentry")
    public String listEntry() {
        return "listentry";}

    @GetMapping("/entry")
    public String entry(Model model) {
        List<Entry> accessByPeriod = listAccessByPeriod();// Call the listAccessByPeriod method to get the data
        Entry test = accessByPeriod.get(1);
        System.out.println(test.getLocalTime());
        model.addAttribute("accessByPeriod", accessByPeriod); // Add the accessByPeriod list to the model
        return "entry";
    }

    @GetMapping("/wrongmail")
    public String wrongEmail() {
        return "wrongmail";}

    @GetMapping("/wrongpassword")
    public String wrongPassword() {
        return "wrongpassword";}

    @GetMapping("/admin")
    public String admin() {
        /*Admin admin = new Admin();
        if (admin.getLoggedIn() == true) {
            return "admin";
        } else
            return "wrongpassword";*/
        return "admin";
    }

    @GetMapping("/admindeleted")
    public String adminDeleted() {
        return "admindeleted";}

    @PostMapping("/adminmade")
    public String adminMade() {
        return "adminmade";}

    @GetMapping("/newuser")
    public String newUser(/*@RequestParam User email, @RequestParam String password, Model model*/) /*throws SQLException*/ {
        /*UseCase useCase = new UseCase();
        String res = useCase.buildUser(email, password);
        if (res.equals("User exists")) {
            return "userexists";
        }
        else
            return "newuser";*/
        return "newuser";
    }

    @PostMapping("/usermade")
    public String userMade() {
        return "usermade";}

    @GetMapping("/deleteuser")
    public String deleteUser() {
        return "deleteuser";}

    @GetMapping("/userdeleted")
    public String userDeleted() {
        return "userdeleted";}

    @GetMapping("/user")
    public String user() {
        return "user";}
}