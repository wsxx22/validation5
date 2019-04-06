package com.example.validation5.exception;

public class PeselExistsException extends RuntimeException {

    public PeselExistsException(String messeage) {
        super(messeage);
    }

}
