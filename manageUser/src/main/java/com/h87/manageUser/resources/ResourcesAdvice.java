package com.h87.manageUser.resources;

import com.h87.manageUser.exception.InternalServerError;
import com.h87.manageUser.exception.ResourcesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourcesAdvice {

    @ExceptionHandler({ResourcesNotFoundException.class})
    public ResponseEntity<String> handleResourceNotFoundException(ResourcesNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler({InternalServerError.class})
    public ResponseEntity<String> handleInternalServerError(InternalServerError exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
}
