package com.example.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class fehler extends RuntimeException {
    public fehler(String message) {
        super(message);
    }
}

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(fehler.class)
    public ResponseEntity<String> handleFehler(fehler ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

}