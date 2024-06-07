package com.pichincha.bank_customer_ms.customer.application.transactional;

import com.pichincha.bank_customer_ms.customer.domain.Customer;

public interface CustomerTransactionalService {

    Customer customerCreate(Customer customer);

    Customer customerFind(String identification);

    boolean customerDelete(String identification);
}
