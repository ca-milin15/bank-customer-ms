package com.pichincha.bank_customer_ms.customer.infrastructure.controller.dto;


import com.pichincha.bank_customer_ms.customer.domain.Customer;
import jakarta.validation.constraints.*;
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

    @NotBlank
    String password;

    boolean status;

    @NotBlank
    String name;

    @NotBlank
    @Pattern(regexp = "^(F|M)$")
    String gender;

    @NotNull
    @Min(18)
    int age;

    @NotBlank
    String identification;

    @NotBlank
    String address;

    @NotBlank
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
