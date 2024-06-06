package com.pichincha.bank_customer_ms.shared.application.exceptions;

public class BusinessRulesRuntimeException extends RuntimeException{

    public BusinessRulesRuntimeException(String message) {
        super(message);
    }
}
