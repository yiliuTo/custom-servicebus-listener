package org.example;

import com.azure.spring.messaging.converter.AzureMessageConverter;
import com.azure.spring.messaging.implementation.config.AbstractAzureListenerEndpoint;
import com.azure.spring.messaging.implementation.listener.adapter.MessagingMessageListenerAdapter;
import com.azure.spring.messaging.listener.MessageListenerContainer;

public class SimpleAzureListenerEndpoint extends AbstractAzureListenerEndpoint {

    @Override
    protected MessagingMessageListenerAdapter createMessageListener(MessageListenerContainer listenerContainer,
                                                                    AzureMessageConverter<?, ?> messageConverter) {
        return new SimpleMessagingMessageListener();
    }
}
