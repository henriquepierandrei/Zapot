package com.zapot.config.auth.dtos;

public record AuthResponseDTO(
        String accessToken,
        String refreshToken,
        String message
) {
}
