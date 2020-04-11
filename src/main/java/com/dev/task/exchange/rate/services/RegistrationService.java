package com.dev.task.exchange.rate.services;

import com.dev.task.exchange.rate.model.User;

public interface RegistrationService {

    User register(String email, String password);
}
