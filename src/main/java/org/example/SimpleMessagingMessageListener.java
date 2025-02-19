package org.example;

import com.azure.messaging.servicebus.ServiceBusReceivedMessageContext;
import com.azure.spring.cloud.service.listener.MessageListener;
import com.azure.spring.messaging.implementation.listener.adapter.MessagingMessageListenerAdapter;
import com.azure.spring.messaging.servicebus.implementation.core.listener.adapter.RecordMessagingMessageListenerAdapter;
import com.azure.spring.messaging.servicebus.support.ServiceBusMessageHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SimpleMessagingMessageListener extends RecordMessagingMessageListenerAdapter {

    @Override
    public void onMessage(ServiceBusReceivedMessageContext messageContext) {
        Map<String, Object> headers = new HashMap<>();
        headers.put(ServiceBusMessageHeaders.RECEIVED_MESSAGE_CONTEXT, messageContext);

        Message<?> message = getMessageConverter().toMessage(messageContext.getMessage(), new MessageHeaders(headers),
            payloadType);
        String string = new String((byte[]) message.getPayload(), StandardCharsets.UTF_8);
        System.out.println(string);
    }
}
