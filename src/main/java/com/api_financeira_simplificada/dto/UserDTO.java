package com.api_financeira_simplificada.dto;

import com.api_financeira_simplificada.domain.user.EnumUserType;

import java.math.BigDecimal;

public record UserDTO(String name, String document, String email, String password, EnumUserType userType, BigDecimal balance) {
}
