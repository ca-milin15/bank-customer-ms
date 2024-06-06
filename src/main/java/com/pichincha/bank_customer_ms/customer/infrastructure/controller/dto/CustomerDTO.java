package com.pichincha.bank_customer_ms.customer.infrastructure.controller.dto;


import com.pichincha.bank_customer_ms.customer.domain.Customer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

@Getter
@Setter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CustomerDTO {

    BigInteger id;
    String password;
    boolean status;
    String name;
    String gender;
    int age;
    String identification;
    String address;
    String phone;

    public Customer toCustomer(){
        return Customer.builder()
                .password(password)
                .status(true)
                .nombre(name)
                .genero(gender)
                .edad(age)
                .identificacion(identification)
                .direccion(address)
                .telefono(phone)
                .build();
    }
}
