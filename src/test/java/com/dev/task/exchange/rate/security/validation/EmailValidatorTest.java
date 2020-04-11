package com.dev.task.exchange.rate.security.validation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import javax.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;

class EmailValidatorTest {
    private static final String VALID_GMAIL_EMAIL = "mishabeheka@gmail.com";
    private static final String VALID_UKR_NET_EMAIL = "misha_beheka@ukr.net";
    private static final String VALID__BIGMIR_NET_EMAIL = "misha@bigmir.net";
    private static final String INVALID_KOL_EMAIL = "Kolia@com";
    private static final String INVALID_NOT_DOG_EMAIL = "Somebody.com";
    private static final String INVALID_EMAIL_WITH_DOLLAR = "Somebody$com.net";

    private EmailValidator emailValidator = new EmailValidator();
    private ConstraintValidatorContext mockConstraintValidatorContext = mock(ConstraintValidatorContext.class);

    @Test
    void whenGetValidEmail() {
        assertTrue(emailValidator.isValid(VALID_GMAIL_EMAIL, mockConstraintValidatorContext));
        assertTrue(emailValidator.isValid(VALID_UKR_NET_EMAIL, mockConstraintValidatorContext));
        assertTrue(emailValidator.isValid(VALID__BIGMIR_NET_EMAIL, mockConstraintValidatorContext));
    }
    @Test
    public void whenGetInvalidEmail() {
        assertFalse(emailValidator.isValid(INVALID_KOL_EMAIL, mockConstraintValidatorContext));
        assertFalse(emailValidator.isValid(INVALID_NOT_DOG_EMAIL, mockConstraintValidatorContext));
        assertFalse(emailValidator.isValid(INVALID_EMAIL_WITH_DOLLAR, mockConstraintValidatorContext));
    }
}