package com.example.demo.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class meineexception extends RuntimeException {
    public meineexception(String message) {
        super(message);
    }
}

@RestControllerAdvice
class GlobalExceptionHandler {

    // 404 Not Found für mitarbeiternotfoundexception
    @ExceptionHandler(mitarbeiternotfoundexception.class)
    public ResponseEntity<?> handlenotfoundexception(mitarbeiternotfoundexception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    // 400 Bad Request für meineexception
    @ExceptionHandler(meineexception.class)
    public ResponseEntity<?> handleMeineException(meineexception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}