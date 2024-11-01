package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.security.UserDetailsImp;
import ru.kata.spring.boot_security.demo.service.UserServiceDetailisImp;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceDetailisImp userServiceDetailisImp;

    @Autowired
    public UserController(UserServiceDetailisImp userServiceDetailisImp) {
        this.userServiceDetailisImp = userServiceDetailisImp;
    }

    @GetMapping
    public String userInfo(Model model, @AuthenticationPrincipal UserDetailsImp userDetail) {

        User user = userDetail.getUser();
        model.addAttribute("user", user);

        return "user";
    }
}