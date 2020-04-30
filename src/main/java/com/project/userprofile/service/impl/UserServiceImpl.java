package com.project.userprofile.service.impl;

import com.project.userprofile.controller.request.UserCreationRequest;
import com.project.userprofile.controller.response.UserResponse;
import com.project.userprofile.domain.User;

public class UserServiceImpl {

    public UserResponse createUserFrom(UserCreationRequest request) {

        User newUser = new User(request.getEmail(), request.getFirstName(), request.getLastName());

        return new UserResponse(newUser);
    }
}
