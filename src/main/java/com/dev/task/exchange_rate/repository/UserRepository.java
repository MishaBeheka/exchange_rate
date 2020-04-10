package com.dev.task.exchange_rate.repository;

import com.dev.task.exchange_rate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
