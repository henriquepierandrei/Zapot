package com.zapot.config.auth.dtos;

public record RegisterRequestDTO(
        String name,
        String email,
        String password
) {
}
