package com.zapot.config.auth.dtos;

public record LoginRequestDTO(
        String email,
        String password
) {
}
