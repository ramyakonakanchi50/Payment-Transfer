package com.demo.paymenttransfer.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final String errorMessage;

    public CustomException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
