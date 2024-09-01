package com.oath.rest.service;

import com.oath.rest.dto.CommentDTO;
import com.oath.rest.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getPosts();

    List<CommentDTO> postComments(String postId);
}
