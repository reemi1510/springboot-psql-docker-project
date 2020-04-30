package com.project.userprofile.service;

import com.project.userprofile.controller.request.UserCreationRequest;
import com.project.userprofile.controller.response.UserResponse;
import com.project.userprofile.service.impl.UserServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl sut;

    @Test
    public void can_create_user_from_request_and_save() {
        List appointments = new ArrayList();
        UserCreationRequest request = new UserCreationRequest("test@email.com", "Jane", "Doe", appointments);
        UserResponse response = sut.createUserFrom(request);

        assertThat(response).isNotNull();
    }
}
