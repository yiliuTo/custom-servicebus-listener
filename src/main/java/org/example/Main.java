package org.example;

import com.azure.spring.messaging.implementation.annotation.EnableAzureMessaging;
import com.azure.spring.messaging.servicebus.core.ServiceBusTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableAzureMessaging
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Main.class, args);
        ServiceBusTemplate serviceBusTemplate = run.getBean(ServiceBusTemplate.class);
        serviceBusTemplate.send("que001", MessageBuilder.withPayload("test").build());
    }
}