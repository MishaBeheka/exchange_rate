package com.dev.task.exchange_rate.services.implementation;

import com.dev.task.exchange_rate.model.Role;
import com.dev.task.exchange_rate.model.User;
import com.dev.task.exchange_rate.services.AuthenticationService;
import com.dev.task.exchange_rate.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String email, String password) {
        User user = userService.findUserByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new RuntimeException("");
    }

    @Override
    public User register(String email, String password) {
        User createdUser = new User();
        Role role = new Role();
        role.setRoleName("ADMIN");
        createdUser.setEmail(email);
        createdUser.setPassword(passwordEncoder.encode(password));
        createdUser.getRoles().add(role);
        return userService.create(createdUser);
    }
}
