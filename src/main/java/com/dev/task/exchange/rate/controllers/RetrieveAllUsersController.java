package com.dev.task.exchange.rate.controllers;

import com.dev.task.exchange.rate.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RetrieveAllUsersController {

    private final UserService userService;

    public RetrieveAllUsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/retrieve-all-users")
    public String retrieveAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "showUserTable";
    }
}
