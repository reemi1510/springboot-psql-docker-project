package com.project.userprofile.service;

import com.project.userprofile.controller.request.UserCreationRequest;
import com.project.userprofile.controller.response.UserResponse;

public interface UserService {

    UserResponse createUserFrom(UserCreationRequest request);
}
