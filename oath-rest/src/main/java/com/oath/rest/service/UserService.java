package com.oath.rest.service;

import com.oath.rest.dto.PostDTO;
import com.oath.rest.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();
    List<PostDTO> userPost(String userId);
}
