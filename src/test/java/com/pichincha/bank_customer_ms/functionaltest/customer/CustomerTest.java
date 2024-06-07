package com.pichincha.bank_customer_ms.functionaltest.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.bank_customer_ms.customer.infrastructure.controller.dto.CustomerDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void creatCustomer() throws Exception {
        var request = CustomerDTO.builder()
                .identification("1010111")
                .password("1234")
                .name("Juan")
                .gender("F")
                .age(20)
                .address("Crrerr")
                .phone("21312312")
                .build();
        var requestAsString = objectMapper.writeValueAsString(request);
        this.mockMvc.perform(
                post("/clientes")
                        .content(requestAsString)
                        .contentType("application/json")
                ).andExpect(status().isAccepted());
    }
}
