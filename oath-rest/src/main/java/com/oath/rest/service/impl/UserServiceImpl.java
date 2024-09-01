package com.oath.rest.service.impl;

import com.oath.rest.client.RestClient;
import com.oath.rest.dto.PostDTO;
import com.oath.rest.dto.RequestDetails;
import com.oath.rest.dto.UserDTO;
import com.oath.rest.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Value("${oath.rest.public.base.url}")
    public String baseUrl;
    @Value("${oath.rest.public.end-point.users}")
    public String userEndPoint;

    @Value("${oath.rest.public.end-point.posts}")
    public String postEndPoint;
    private final RestClient restClient;


    @Override
    public List<UserDTO> getUsers() {
        final String usersUrl = baseUrl + userEndPoint;
        List<UserDTO> userDTOS = new ArrayList<>();
        try {
            RequestDetails userRequestDetails = RequestDetails.builder().requestType(HttpMethod.GET).
                    uriComponentsBuilder(UriComponentsBuilder.fromHttpUrl(usersUrl)).build();
            final ResponseEntity<List<UserDTO>> userResponse = restClient.execute(userRequestDetails, null, List.class);
            userDTOS = userResponse.getBody();
        } catch (Exception exception) {
            log.error("Error occurred {} ", exception.getMessage());
        }
        return userDTOS;
    }

    @Override
    public List<PostDTO> userPost(String userId) {
        final String postUrl = baseUrl +userEndPoint+"/"+userId+ postEndPoint;
        List<PostDTO> postDTOS = new ArrayList<>();
        try {
            RequestDetails postRequestDetails = RequestDetails.builder().requestType(HttpMethod.GET).
                    uriComponentsBuilder(UriComponentsBuilder.fromHttpUrl(postUrl)).build();
            final ResponseEntity<List<PostDTO>> postResponse = restClient.execute(postRequestDetails, null, List.class);
            postDTOS = postResponse.getBody();
        } catch (Exception exception) {
            log.error("Error occurred {}", exception.getMessage());
        }
        return postDTOS;
    }


}
