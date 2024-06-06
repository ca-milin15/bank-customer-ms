package com.pichincha.bank_customer_ms.shared.infrastructure.publisher;

public interface PublisherService {

    boolean publishEvent(String event);
}
