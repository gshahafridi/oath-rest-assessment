package com.oath.rest.client;

import com.oath.rest.dto.RequestDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RestClient<T, V> {
    private final RestTemplate restTemplate;
    public ResponseEntity<V> execute(RequestDetails requestDetails, T data, Class<V> genericClass) {
        HttpEntity<T> entity = new HttpEntity<T>(data, requestDetails.getHeaders());
        ResponseEntity<V> response = restTemplate.exchange(requestDetails.getUriComponentsBuilder().buildAndExpand().toUri(), requestDetails.getRequestType(),
                entity, genericClass);
        return response;
    }
}
