package com.pichincha.bank_customer_ms.shared.application.usecases;

public interface QueryUseCase  <T>{

    T executeQuery(T command);
}
