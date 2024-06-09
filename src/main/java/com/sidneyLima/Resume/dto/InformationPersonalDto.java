package com.sidneyLima.Resume.dto;

import jakarta.validation.constraints.Email;

public record InformationPersonalDto(
        @Email
        String fullName,
        String email,
        String position,
        String country,
        String state,
        String city
) {
}
