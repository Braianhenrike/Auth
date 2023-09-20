package com.Auth.DTO;

import org.springframework.validation.annotation.Validated;

@Validated
public record ProductRequestDTO(
        String name,

        Integer price
) {
}