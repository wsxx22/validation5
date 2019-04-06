package com.example.validation5.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@AllArgsConstructor
public class ExceptionDisplayed {

    HttpStatus status;
    List<String> errors;

    public ExceptionDisplayed(HttpStatus status, String error) {
        this.status = status;
        errors = List.of(error);
    }
}
