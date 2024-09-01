package com.oath.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDetails {
    private String url;
    private HttpMethod requestType;
    private UriComponentsBuilder uriComponentsBuilder;
    private HttpHeaders headers;
    private Map<String, String> urlParams=new HashMap<>();
}
