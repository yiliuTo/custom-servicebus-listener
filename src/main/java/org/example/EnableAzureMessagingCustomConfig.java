package org.example;

import com.azure.spring.messaging.implementation.annotation.AzureListenerConfigurer;
import com.azure.spring.messaging.implementation.config.AzureListenerEndpointRegistrar;
import com.azure.spring.messaging.implementation.config.AzureListenerEndpointRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnableAzureMessagingCustomConfig implements AzureListenerConfigurer {

    @Override
    public void configureAzureListeners(AzureListenerEndpointRegistrar registrar) {
        registrar.setEndpointRegistry(customRegistry());

        // Also register a custom endpoint
        SimpleAzureListenerEndpoint endpoint = new SimpleAzureListenerEndpoint();
        endpoint.setId("myCustomEndpointId");
        endpoint.setDestination("que001");
        registrar.registerEndpoint(endpoint);
    }

    @Bean
    public AzureListenerEndpointRegistry customRegistry() {
        return new AzureListenerEndpointRegistry();
    }

}
