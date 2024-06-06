package com.pichincha.bank_customer_ms.customer.infrastructure.repository;

import com.pichincha.bank_customer_ms.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
