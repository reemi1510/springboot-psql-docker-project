package com.project.userprofile.service.impl;

import com.project.userprofile.controller.request.UserCreationRequest;
import com.project.userprofile.controller.response.UserResponse;
import com.project.userprofile.domain.User;
import com.project.userprofile.persistence.UserRepository;
import com.project.userprofile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse createUserFrom(UserCreationRequest request) {

        User newUser = new User(request.getEmail(), request.getFirstName(), request.getLastName());

        User user = userRepository.save(newUser);

        return new UserResponse(user);
    }
}
