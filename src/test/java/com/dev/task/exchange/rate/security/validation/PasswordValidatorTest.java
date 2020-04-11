package com.dev.task.exchange.rate.security.validation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import com.dev.task.exchange.rate.dto.RegisteredUserRequestDto;
import javax.validation.ConstraintValidatorContext;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    private static final RegisteredUserRequestDto USER_WITH_VALID_PSW = new RegisteredUserRequestDto();
    private static final RegisteredUserRequestDto USER_WITHOUT_VALID_PSW = new RegisteredUserRequestDto();
    private PasswordValidator passwordValidator;
    private ConstraintValidatorContext mockConstraintValidatorContext = mock(ConstraintValidatorContext.class);

    @BeforeEach()
    public void setUp() {
        passwordValidator = new PasswordValidator();
        USER_WITH_VALID_PSW.setPassword("Java11");
        USER_WITH_VALID_PSW.setRepeatPassword("Java11");
        USER_WITHOUT_VALID_PSW.setPassword("java13");
        USER_WITHOUT_VALID_PSW.setRepeatPassword("JAVA13");
    }

    @Test
    void whenPasswordIsValid() {
        assertTrue(passwordValidator.isValid(USER_WITH_VALID_PSW, mockConstraintValidatorContext));
    }

    @Test
    public void whenPasswordIsntValid() {
        assertFalse(passwordValidator.isValid(USER_WITHOUT_VALID_PSW, mockConstraintValidatorContext));
    }
}