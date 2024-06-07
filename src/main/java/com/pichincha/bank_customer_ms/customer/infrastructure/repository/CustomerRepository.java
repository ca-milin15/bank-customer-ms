package com.pichincha.bank_customer_ms.customer.infrastructure.repository;

import com.pichincha.bank_customer_ms.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Optional<Customer> findByIdentification(String identification);

    Integer deleteByIdentification(String identification);
}
