package com.dev.task.exchange_rate.controllers;

import com.dev.task.exchange_rate.dto.RegisteredUserRequestDto;
import com.dev.task.exchange_rate.services.RegistrationService;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping(value = "/registration")
    public String showRegistrationForm() {
        return "registrationForm";
    }

    @PostMapping(value = "/registration")
    public String registration(@Valid RegisteredUserRequestDto userRequestDto) {
        registrationService.register(userRequestDto.getEmail(),
                userRequestDto.getPassword());
        return "index";
    }
}
