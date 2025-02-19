package org.example;

import com.azure.spring.messaging.servicebus.implementation.core.annotation.ServiceBusListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//@Service
//public class MessageHandler {
//
//    private static final String QUEUE_NAME = "que001";
//
//    @ServiceBusListener(destination = QUEUE_NAME)
//    public void handleMessageFromServiceBus(String msg) {
//        System.out.printf("Consume message: %s%n", msg);
//    }
//
//}
