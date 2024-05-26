package com.api_financeira_simplificada.dto;

import org.springframework.http.HttpStatus;

public record NotifyClientDTO(HttpStatus status, String message) {

}
