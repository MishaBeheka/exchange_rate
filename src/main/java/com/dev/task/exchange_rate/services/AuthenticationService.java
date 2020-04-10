package com.dev.task.exchange_rate.services;

import com.dev.task.exchange_rate.model.User;

public interface AuthenticationService {
    User login(String email, String password);

    User register(String email, String password);
}
