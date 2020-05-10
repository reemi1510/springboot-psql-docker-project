package com.project.userprofile.controller;

import com.project.userprofile.controller.request.UserCreationRequest;
import com.project.userprofile.controller.response.UserResponse;
import com.project.userprofile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "api/v1/users")
@RestController
public class UserProfileController {

    @Autowired
    protected UserService userService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserCreationRequest userCreationRequest) {

        UserResponse userResponse = userService.createUserFrom(userCreationRequest);

        return ResponseEntity
                .status(201)
                .body(userResponse);
    }
}
