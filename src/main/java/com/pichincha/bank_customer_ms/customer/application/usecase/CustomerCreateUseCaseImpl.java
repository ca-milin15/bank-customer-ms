package com.pichincha.bank_customer_ms.customer.application.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.bank_customer_ms.customer.application.transactional.CustomerTransactionalService;
import com.pichincha.bank_customer_ms.customer.infrastructure.controller.dto.CustomerDTO;
import com.pichincha.bank_customer_ms.shared.application.usecases.CommandUsecase;
import com.pichincha.bank_customer_ms.shared.infrastructure.publisher.RabbitMQPublisherService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("CustomerCreateUseCase")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class CustomerCreateUseCaseImpl implements CommandUsecase<CustomerDTO> {

    CustomerTransactionalService customerTransactionalService;
    ObjectMapper objectMapper;

    @Qualifier("CustomerCreatePublisher")
    RabbitMQPublisherService rabbitMQPublisherService;

    @Override
    public CustomerDTO executeCommand(CustomerDTO request) {
        try {
            var customerCreated = customerTransactionalService.customerCreate(request.toCustomer());
            var customerAsDto = customerCreated.toDTO();
            rabbitMQPublisherService.publishEvent(objectMapper.writeValueAsString(customerAsDto));
            return customerAsDto;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
