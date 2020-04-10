package com.dev.task.exchange_rate.security;

import static org.springframework.security.core.userdetails.User.UserBuilder;
import static org.springframework.security.core.userdetails.User.withUsername;

import com.dev.task.exchange_rate.model.Role;
import com.dev.task.exchange_rate.model.User;
import com.dev.task.exchange_rate.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetails(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Can't find user with email " + email);
        }
        UserBuilder builder = withUsername(email);
        builder.password(user.getPassword());
        builder.roles(getRoles(user));
        return builder.build();
    }

    private String[] getRoles(User user) {
        return user.getRoles()
                .stream()
                .map(Role::getRoleName)
                .toArray(String[]::new);
    }
}
