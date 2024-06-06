package com.pichincha.bank_customer_ms.customer.application.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface CommandUsecase <T> {

    T executeCommand(T request) throws JsonProcessingException;
}
