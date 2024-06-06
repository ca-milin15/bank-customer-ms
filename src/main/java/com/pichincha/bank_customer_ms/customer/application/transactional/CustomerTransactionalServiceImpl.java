package com.pichincha.bank_customer_ms.customer.application.transactional;

import com.pichincha.bank_customer_ms.customer.domain.Customer;
import com.pichincha.bank_customer_ms.customer.infrastructure.repository.CustomerRepository;
import com.pichincha.bank_customer_ms.shared.application.exceptions.BusinessRulesRuntimeException;
import com.pichincha.bank_customer_ms.shared.infrastructure.config.SystemPropertiesConfig;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CustomerTransactionalServiceImpl implements CustomerTransactionalService{

    CustomerRepository customerRepository;
    SystemPropertiesConfig systemPropertiesConfig;

    @Override
    public Customer customerCreate(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            log.error("CustomerTransactionalServiceImpl.customerCreate DataIntegrityViolationException {} ",
                    e.getMessage());
            throw new BusinessRulesRuntimeException(
                    systemPropertiesConfig.getMessages().getError().getCustomerCreateDetailedError());
        } catch (Exception e) {
            log.error("CustomerTransactionalServiceImpl.customerCreate Exception {} ",
                    e.getMessage());
            throw new BusinessRulesRuntimeException(
                    systemPropertiesConfig.getMessages().getError().getCustomerCreateError());
        }
    }
}
