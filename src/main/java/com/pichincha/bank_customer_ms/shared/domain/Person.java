package com.pichincha.bank_customer_ms.shared.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class Person {

    @Id
    @SequenceGenerator(name = "person_sequence", sequenceName = "tbl_customer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
    BigInteger id;

    String name;
    String gender;
    int age;
    String identification;
    String address;
    String phone;

    public Person(String nombre, String genero, int edad, String identificacion, String direccion, String telefono) {
        this.name = nombre;
        this.gender = genero;
        this.age = edad;
        this.identification = identificacion;
        this.address = direccion;
        this.phone = telefono;
    }
}
