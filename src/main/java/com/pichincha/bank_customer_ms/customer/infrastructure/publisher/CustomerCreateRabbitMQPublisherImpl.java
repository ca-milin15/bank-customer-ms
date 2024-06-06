package com.pichincha.bank_customer_ms.customer.infrastructure.publisher;

import com.pichincha.bank_customer_ms.shared.infrastructure.publisher.RabbitMQPublisherService;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service("CustomerCreatePublisher")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CustomerCreateRabbitMQPublisherImpl implements RabbitMQPublisherService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${spring.amqp.bank-exchange-new-customer}")
    String bankExchangeNewCustomer;

    @Override
    public boolean publishEvent(String event) {
        var messageProperties = new MessageProperties();
        var message = new Message(event.getBytes(), messageProperties);
        rabbitTemplate.send(bankExchangeNewCustomer, "", message);
        return true;
    }
}
