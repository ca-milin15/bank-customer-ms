package com.pichincha.bank_customer_ms.customer.application.usecase;

import com.pichincha.bank_customer_ms.customer.application.transactional.CustomerTransactionalService;
import com.pichincha.bank_customer_ms.customer.infrastructure.controller.dto.CustomerDTO;
import com.pichincha.bank_customer_ms.shared.application.usecases.CommandUsecase;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("CustomerDeleteUseCase")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CustomerDeleteUseCaseImpl implements CommandUsecase<CustomerDTO> {

    CustomerTransactionalService customerTransactionalService;

    @Override
    public CustomerDTO executeCommand(CustomerDTO customerDTO) {
        customerTransactionalService.customerDelete(customerDTO.getIdentification());
        return CustomerDTO.builder().build();
    }
}
