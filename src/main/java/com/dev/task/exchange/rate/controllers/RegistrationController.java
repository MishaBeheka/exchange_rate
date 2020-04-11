package com.dev.task.exchange.rate.controllers;

import com.dev.task.exchange.rate.dto.RegisteredUserRequestDto;
import com.dev.task.exchange.rate.services.RegistrationService;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
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
        log.info("Registered a new user with email " + userRequestDto.getEmail());
        return "index";
    }
}
