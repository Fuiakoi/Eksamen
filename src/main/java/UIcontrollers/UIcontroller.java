package UIcontrollers;
// package com.RegisterMedSQLite.RegisterMedSqlite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UIcontroller {

    @GetMapping("/start")
    public String start() {
        return "start";
    }

    @PostMapping("/start")
    public String start(@RequestParam String username, @RequestParam String password) {
        // handle login request
        return "loginAnswer";
    }

    /*@GetMapping("/find")
    public String find(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
     model.addAttribute("name", name);
     return "find";
    }*/

    /*@PostMapping("/find")
    public String login(@RequestParam String username, @RequestParam String password, Model model) throws SQLException {
        UseCase uc = new UseCase();
        String res = uc.loginCheck(username, password);
        model.addAttribute("answer", res);
        return "resFind";
    }*/
}