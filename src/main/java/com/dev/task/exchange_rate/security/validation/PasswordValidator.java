package com.dev.task.exchange_rate.security.validation;

import com.dev.task.exchange_rate.annotations.PasswordValidate;
import com.dev.task.exchange_rate.dto.RegisteredUserRequestDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements
        ConstraintValidator<PasswordValidate, RegisteredUserRequestDto> {
    @Override
    public void initialize(PasswordValidate constraintAnnotation) {

    }

    @Override
    public boolean isValid(RegisteredUserRequestDto registeredUserRequestDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        return registeredUserRequestDto.getPassword()
                .equals(registeredUserRequestDto.getRepeatPassword());
    }
}