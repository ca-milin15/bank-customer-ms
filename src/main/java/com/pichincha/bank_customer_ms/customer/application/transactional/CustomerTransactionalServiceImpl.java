package com.pichincha.bank_customer_ms.customer.application.transactional;

import com.netflix.discovery.provider.Serializer;
import com.pichincha.bank_customer_ms.customer.domain.Customer;
import com.pichincha.bank_customer_ms.customer.infrastructure.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CustomerTransactionalServiceImpl implements CustomerTransactionalService{

    CustomerRepository customerRepository;

    @Override
    public Customer customerCreate(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (Exception e) {
            log.error("CustomerTransactionalServiceImpl.customerCreate {} ",
                    e.getMessage());
            throw new RuntimeException("Error al crear el cliente"); // TODO Create a custom exception
        }
    }
}
