package com.pichincha.bank_customer_ms.customer.application.usecase;

import com.pichincha.bank_customer_ms.customer.application.transactional.CustomerTransactionalService;
import com.pichincha.bank_customer_ms.customer.infrastructure.controller.dto.CustomerDTO;
import com.pichincha.bank_customer_ms.shared.application.usecases.QueryUseCase;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("CustomerFindUseCase")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CustomerFindUseCaseImpl implements QueryUseCase <CustomerDTO> {

    CustomerTransactionalService customerTransactionalService;

    @Override
    public CustomerDTO executeQuery(CustomerDTO customerDTO) {
        return customerTransactionalService.customerFind(customerDTO.getIdentification()).toDTO();
    }
}
