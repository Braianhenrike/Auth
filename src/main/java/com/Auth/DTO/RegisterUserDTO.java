package com.Auth.DTO;

import org.springframework.validation.annotation.Validated;

import com.Auth.enums.UserRole;


@Validated
public record RegisterUserDTO(String email, String password, UserRole role) {

}
