package com.dev.task.exchange_rate.services;

import com.dev.task.exchange_rate.model.User;
import java.util.List;

public interface UserService {
    User create(User user);

    User findUserByEmail(String email);

    List<User> getAllUsers();
}
