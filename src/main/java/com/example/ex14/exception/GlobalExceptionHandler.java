package com.example.ex14.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({InvalidDOBException.class})
    public ResponseEntity<ErrorResponse> InvalidDOBException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(400);
        errorResponse.setDescription(e.getMessage());
        return ResponseEntity.status(403).body(errorResponse);

    }

    @ExceptionHandler({InvalidFullNameException.class})
    public ResponseEntity<ErrorResponse> InvalidFullNameException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(400);
        errorResponse.setDescription(e.getMessage());
        return ResponseEntity.status(403).body(errorResponse);

    }
    @ExceptionHandler({InvalidPhoneNumberException.class})
    public ResponseEntity<ErrorResponse> InvalidPhoneNumberException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(400);
        errorResponse.setDescription(e.getMessage());
        return ResponseEntity.status(403).body(errorResponse);

    }


    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> Exception(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(500);
        errorResponse.setDescription(e.getMessage());
        return ResponseEntity.status(500).body(errorResponse);


    }
}
