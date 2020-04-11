package com.dev.task.exchange_rate.dto;

import com.dev.task.exchange_rate.annotations.EmailValidate;
import com.dev.task.exchange_rate.annotations.PasswordValidate;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@PasswordValidate
public class RegisteredUserRequestDto {
    @NotEmpty
    @EmailValidate
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String repeatPassword;
}
