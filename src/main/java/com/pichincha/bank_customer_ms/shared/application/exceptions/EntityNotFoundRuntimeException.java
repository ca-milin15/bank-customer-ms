package com.pichincha.bank_customer_ms.shared.application.exceptions;

public class EntityNotFoundRuntimeException extends RuntimeException {

        public EntityNotFoundRuntimeException(String message) {
            super(message);
        }
}
