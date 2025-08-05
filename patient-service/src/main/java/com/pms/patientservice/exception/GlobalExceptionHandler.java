package com.pms.patientservice.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Existing handler
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // New handler for enum and other conversion errors
    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<?> handleHttpMessageConversion(HttpMessageConversionException ex) {
        Throwable cause = ex.getCause();

        if (cause instanceof InvalidFormatException formatEx) {
            Class<?> targetType = formatEx.getTargetType();

            if (targetType.isEnum()) {
                Object[] constants = targetType.getEnumConstants();
                String[] allowedValues = new String[constants.length];
                for (int i = 0; i < constants.length; i++) {
                    allowedValues[i] = constants[i].toString();
                }

                return ResponseEntity
                        .badRequest()
                        .body(Map.of(
                                "error", "Invalid value for field. Allowed values: " + String.join(", ", allowedValues)
                        ));
            }
        }

        // Fallback for other conversion errors
        return ResponseEntity
                .badRequest()
                .body(Map.of("error", "Invalid request data format"));
    }
}
