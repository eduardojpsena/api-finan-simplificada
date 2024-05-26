package com.api_financeira_simplificada.config;

import com.api_financeira_simplificada.dto.StatusResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FinanceExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity generalException(Exception e) {
        StatusResponseDTO statusResponse = new StatusResponseDTO(500, e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(statusResponse);
    }
}
