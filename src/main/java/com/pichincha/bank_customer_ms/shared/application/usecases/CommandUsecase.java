package com.pichincha.bank_customer_ms.shared.application.usecases;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface CommandUsecase <T> {

    T executeCommand(T request);
}
