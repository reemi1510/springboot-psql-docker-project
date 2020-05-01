package com.project.userprofile.controller;

import com.project.userprofile.controller.request.UserCreationRequest;
import com.project.userprofile.controller.response.UserResponse;
import com.project.userprofile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProfileController {

    @Autowired
    protected UserService userService;

    public ResponseEntity<UserResponse> registerUser(UserCreationRequest userCreationRequest) {

        UserResponse userResponse = userService.createUserFrom(userCreationRequest);

        return ResponseEntity
                .status(201)
                .body(userResponse);
    }
}
