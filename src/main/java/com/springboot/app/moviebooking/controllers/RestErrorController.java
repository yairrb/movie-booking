package com.springboot.app.moviebooking.controllers;

import com.springboot.app.moviebooking.exceptions.NoSuchElementFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.NoResultException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class RestErrorController extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {NoSuchElementFoundException.class, NoResultException.class, NoSuchElementException.class})
    public ResponseEntity<Object> exceptionNoSuchElementFound(RuntimeException ex, WebRequest request) {
        String message = "Element or resource not found";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

}
