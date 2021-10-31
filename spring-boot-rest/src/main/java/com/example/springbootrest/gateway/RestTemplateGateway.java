package com.example.springbootrest.gateway;

import com.example.springbootrest.config.RestConfig;
import com.example.springbootrest.dto.ResponseDto;

import lombok.AllArgsConstructor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
@ConditionalOnProperty(name = "rest.template.enabled", havingValue = "true")
public class RestTemplateGateway implements Gateway {

    private final RestTemplate restTemplate;
    private RestConfig restConfig;

    @Override
    public ResponseDto get() {
        return restTemplate.getForObject(restConfig.getUrl(), ResponseDto.class);
    }
}
