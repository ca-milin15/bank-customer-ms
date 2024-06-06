package com.pichincha.bank_customer_ms.customer.infrastructure.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.pichincha.bank_customer_ms.customer.application.usecase.CommandUsecase;
import com.pichincha.bank_customer_ms.customer.infrastructure.controller.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    @Qualifier("CustomerCreateUseCase")
    CommandUsecase<CustomerDTO> customerCreateUseCase;

    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public CustomerDTO userCreateProcess(@RequestBody CustomerDTO customerDTO) throws JsonProcessingException {
        return customerCreateUseCase.executeCommand(customerDTO);
    }
}
