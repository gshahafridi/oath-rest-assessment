package com.oath.rest.service.impl;

import com.oath.rest.client.RestClient;
import com.oath.rest.dto.CommentDTO;
import com.oath.rest.dto.PostDTO;
import com.oath.rest.dto.RequestDetails;
import com.oath.rest.service.PostService;
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
public class PostServiceImpl implements PostService {
    @Value("${oath.rest.public.base.url}")
    public String baseUrl;
    @Value("${oath.rest.public.end-point.posts}")
    public String postEndPoint;
    private final RestClient restClient;
    @Value("${oath.rest.public.end-point.comments}")
    public String commentsEndPoint;

    @Override
    public List<PostDTO> getPosts() {
        final String postUrl = baseUrl + postEndPoint;
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

    @Override
    public List<CommentDTO> postComments(String postId) {
        final String commentsUrl = baseUrl + postEndPoint+"/"+postId+commentsEndPoint;
        List<CommentDTO> commentDTOS = new ArrayList<>();
        try {
            RequestDetails commentRequestDetails = RequestDetails.builder().requestType(HttpMethod.GET).
                    uriComponentsBuilder(UriComponentsBuilder.fromHttpUrl(commentsUrl)).build();
            final ResponseEntity<List<CommentDTO>> commentsResponse = restClient.execute(commentRequestDetails, null, List.class);
            commentDTOS = commentsResponse.getBody();
        } catch (Exception exception) {
            log.error("Error occurred {}", exception.getMessage());
        }
        return commentDTOS;
    }


}
