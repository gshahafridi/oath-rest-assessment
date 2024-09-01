package com.oath.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OathRestApplication {
    final Integer CONNECTION_TIME_OUT=10000;
    final Integer CONNECTION_READ_TIME_OUT=10000;

    public static void main(String[] args) {
        SpringApplication.run(OathRestApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(CONNECTION_TIME_OUT);
        requestFactory.setReadTimeout(CONNECTION_READ_TIME_OUT);
        return  new RestTemplate(requestFactory);
    }

}
