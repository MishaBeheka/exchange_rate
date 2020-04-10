package com.dev.task.exchange_rate.dto;

import lombok.Data;

@Data
public class UserLoginRequestDto {
    private String email;
    private String password;
}
