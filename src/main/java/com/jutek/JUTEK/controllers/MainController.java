package com.jutek.JUTEK.controllers;

import com.jutek.JUTEK.model.User;
import com.jutek.JUTEK.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    private String mainPage() {

        return "index";
    }


    @PostMapping("/userCreator")
    private String putWordToDb(User user) {
        userService.saveUser(user);
        return "redirect:/newUser";
    }

    @GetMapping("/newUser")
    private String putUserToDb(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }


}
