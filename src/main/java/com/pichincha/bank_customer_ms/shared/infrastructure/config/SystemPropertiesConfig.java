package com.pichincha.bank_customer_ms.shared.infrastructure.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "system-properties")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SystemPropertiesConfig {

    Message messages;

    @Getter
    @Setter
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Message {
        Error error;

        @Getter
        @Setter
        @FieldDefaults(level = AccessLevel.PRIVATE)
        public static class Error {
            String customerCreateDetailedError;
            String customerCreateError;
        }
    }
}
