package com.api_financeira_simplificada.dto;

import com.api_financeira_simplificada.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String name, String document, String email, String password, UserType userType, BigDecimal balance) {
}
