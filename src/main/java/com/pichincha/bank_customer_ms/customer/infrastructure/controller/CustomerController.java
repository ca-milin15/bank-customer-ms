package com.pichincha.bank_customer_ms.customer.infrastructure.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.pichincha.bank_customer_ms.customer.infrastructure.controller.dto.CustomerDTO;
import com.pichincha.bank_customer_ms.shared.application.usecases.CommandUsecase;
import com.pichincha.bank_customer_ms.shared.application.usecases.QueryUseCase;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CustomerController {

    CommandUsecase<CustomerDTO> customerCreateUseCase;
    QueryUseCase<CustomerDTO> customerQueryUseCase;
    CommandUsecase<CustomerDTO> customerDeleteUseCase;

    public CustomerController(@Qualifier("CustomerCreateUseCase") CommandUsecase<CustomerDTO> customerCreateUseCase,
                              @Qualifier("CustomerFindUseCase") QueryUseCase<CustomerDTO> customerQueryUseCase,
                              @Qualifier("CustomerDeleteUseCase") CommandUsecase<CustomerDTO> customerDeleteUseCase) {
        this.customerCreateUseCase = customerCreateUseCase;
        this.customerQueryUseCase = customerQueryUseCase;
        this.customerDeleteUseCase = customerDeleteUseCase;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public CustomerDTO userCreateProcess(@RequestBody @Validated CustomerDTO customerDTO) throws JsonProcessingException {
        return customerCreateUseCase.executeCommand(customerDTO);
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public CustomerDTO getUserProcess(
            @RequestParam(required = true) String identification) {
        var customerDTO = CustomerDTO.builder().identification(identification).build();
        return customerQueryUseCase.executeQuery(customerDTO);
    }

    @DeleteMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public CustomerDTO deleteUserProcess(
            @RequestParam(required = true) String identification) {
        var customerDTO = CustomerDTO.builder().identification(identification).build();
        return customerDeleteUseCase.executeCommand(customerDTO);
    }
}
