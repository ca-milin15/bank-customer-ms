package com.pichincha.bank_customer_ms.customer.domain;

import com.pichincha.bank_customer_ms.customer.infrastructure.controller.dto.CustomerDTO;
import com.pichincha.bank_customer_ms.shared.domain.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Table(name = "tbl_customer")
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Customer extends Person {

    @Builder
    public Customer(String nombre, String genero, int edad, String identificacion, String direccion, String telefono,
                    String password, boolean status) {
        super(nombre, genero, edad, identificacion, direccion, telefono);
        this.password = password;
        this.status = status;
    }

    String password;
    boolean status;


    public CustomerDTO toDTO() {
        return CustomerDTO.builder()
                .id(id)
                .password(password)
                .status(status)
                .name(name)
                .gender(gender)
                .age(age)
                .identification(identification)
                .address(address)
                .phone(phone)
                .build();
    }
}
