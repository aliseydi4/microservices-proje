package org.turkcell.customerservice.core.utilities.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientConfig {
    @Bean
    @LoadBalanced
    public WebClient.Builder builder(){
        return WebClient.builder();
    }
}
