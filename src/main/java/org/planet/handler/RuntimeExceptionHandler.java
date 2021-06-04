package org.planet.handler;

import org.planet.models.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RuntimeExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public ExceptionResponse handleTheException(RuntimeException exception) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), LocalDateTime.now());
    }
}
