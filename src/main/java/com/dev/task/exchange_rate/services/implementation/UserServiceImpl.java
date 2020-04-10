package com.dev.task.exchange_rate.services.implementation;

import com.dev.task.exchange_rate.model.User;
import com.dev.task.exchange_rate.repository.UserRepository;
import com.dev.task.exchange_rate.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
