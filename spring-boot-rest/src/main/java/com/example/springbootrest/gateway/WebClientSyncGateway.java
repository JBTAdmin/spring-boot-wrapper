package com.example.springbootrest.gateway;

import com.example.springbootrest.config.RestConfig;
import com.example.springbootrest.dto.ResponseDto;

import lombok.AllArgsConstructor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
@ConditionalOnProperty(name = "rest.template.enabled", havingValue = "false", matchIfMissing = true)
public class WebClientSyncGateway implements Gateway {

    private final WebClient webClient;
    private final RestConfig restConfig;

    @Override
    public ResponseDto get() {
        return webClient.get().uri(restConfig.getUrl()).retrieve().bodyToMono(ResponseDto.class).block();
    }
}
