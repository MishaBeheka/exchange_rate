package com.dev.task.exchange_rate.services;

import com.dev.task.exchange_rate.model.User;

public interface RegistrationService {

    User register(String email, String password);
}