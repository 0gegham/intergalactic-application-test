package org.planet.exception;

import org.springframework.http.HttpStatus;

public class IntergalacticException extends RuntimeException {
    private HttpStatus httpStatus;

    public IntergalacticException(String message) {
        super(message);
    }

    public IntergalacticException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
