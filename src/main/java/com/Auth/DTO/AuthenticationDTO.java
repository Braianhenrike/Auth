package com.Auth.DTO;

import org.springframework.validation.annotation.Validated;

@Validated
public record AuthenticationDTO(String login, String password) {

}