package com.pichincha.bank_customer_ms.unittest.customer.applicationusecases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.bank_customer_ms.customer.application.transactional.CustomerTransactionalService;
import com.pichincha.bank_customer_ms.customer.application.usecase.CustomerCreateUseCaseImpl;
import com.pichincha.bank_customer_ms.customer.infrastructure.controller.dto.CustomerDTO;
import com.pichincha.bank_customer_ms.shared.infrastructure.publisher.RabbitMQPublisherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class CustomerCreateUseCaseImplTest {

    CustomerTransactionalService customerTransactionalService;
    ObjectMapper objectMapper;
    RabbitMQPublisherService rabbitMQPublisherService;

    CustomerCreateUseCaseImpl customerCreateUseCaseImpl;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
        customerTransactionalService = Mockito.mock(CustomerTransactionalService.class);
        rabbitMQPublisherService = Mockito.mock(RabbitMQPublisherService.class);
        customerCreateUseCaseImpl = new CustomerCreateUseCaseImpl(customerTransactionalService, objectMapper, rabbitMQPublisherService);
    }

    @Test
    void testExecuteCommandMethodOkCase() {
        var customerDTO = CustomerDTO.builder().identification("1010111").build();
        when(customerTransactionalService.customerCreate(any())).thenReturn(customerDTO.toCustomer());
        var customerDTOResponse = customerCreateUseCaseImpl.executeCommand(customerDTO);
        assert customerDTOResponse != null;
        verify(customerTransactionalService, times(1)).customerCreate(any());
    }

    @Test
    void testExecuteCommandMethodFailCase() throws JsonProcessingException {
        objectMapper = Mockito.mock(ObjectMapper.class);
        customerCreateUseCaseImpl = new CustomerCreateUseCaseImpl(customerTransactionalService, objectMapper, rabbitMQPublisherService);
        var customerDTO = CustomerDTO.builder().identification("1010111").build();
        when(customerTransactionalService.customerCreate(any())).thenReturn(customerDTO.toCustomer());
        when(objectMapper.writeValueAsString(any())).thenThrow(new JsonProcessingException(""){});
        assertThrows(RuntimeException.class, () -> customerCreateUseCaseImpl.executeCommand(customerDTO));
        verify(customerTransactionalService, times(1)).customerCreate(any());
    }
}
