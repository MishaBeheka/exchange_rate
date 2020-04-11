package com.dev.task.exchange.rate.controllers;

import com.dev.task.exchange.rate.model.Role;
import com.dev.task.exchange.rate.model.User;
import com.dev.task.exchange.rate.services.RoleService;
import com.dev.task.exchange.rate.services.UserService;
import javax.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class InitializeController {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public InitializeController(UserService userService,
                                RoleService roleService,
                                PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initializeFirstUser() {
        Role role = new Role();
        role.setRoleName("ADMIN");
        roleService.create(role);

        User user = new User();
        user.setEmail("FirstEmail@gmail.com");
        user.setPassword(passwordEncoder.encode("1"));
        user.getRoles().add(role);
        userService.create(user);
    }
}
