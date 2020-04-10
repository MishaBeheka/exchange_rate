package com.dev.task.exchange_rate.services.implementation;

import com.dev.task.exchange_rate.model.Role;
import com.dev.task.exchange_rate.model.User;
import com.dev.task.exchange_rate.services.RegistrationService;
import com.dev.task.exchange_rate.services.RoleService;
import com.dev.task.exchange_rate.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RoleService roleService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(UserService userService, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        Role role = roleService.findRoleByRoleName("ADMIN");
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.getRoles().add(role);
        return userService.create(user);
    }
}
