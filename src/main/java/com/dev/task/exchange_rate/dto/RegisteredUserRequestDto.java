package com.dev.task.exchange_rate.dto;

import lombok.Data;

@Data
public class RegisteredUserRequestDto {

    private String email;

    private String password;

    private String repeatPassword;
}
