package com.api_financeira_simplificada.config;

import com.api_financeira_simplificada.common.enums.EnumError;
import com.api_financeira_simplificada.dto.StatusResponseDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FinanceExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity generalException(DataIntegrityViolationException e) {
        StatusResponseDTO statusResponse = new StatusResponseDTO(500, EnumError.USUARIO_JA_CADASTRADO.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(statusResponse);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity generalException(Exception e) {
        StatusResponseDTO statusResponse = new StatusResponseDTO(500, e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(statusResponse);
    }
}
