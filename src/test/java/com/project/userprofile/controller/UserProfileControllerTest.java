package com.project.userprofile.controller;

import com.project.userprofile.controller.request.UserCreationRequest;
import com.project.userprofile.controller.response.UserResponse;
import com.project.userprofile.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserProfileControllerTest {

    @Mock
    UserCreationRequest userCreationRequestMock;

    @Mock
    UserResponse userResponseMock;

    @Mock
    UserService userServiceMock;

    @InjectMocks
    UserProfileController sut;

    @Before
    public void setUp() {
        when(userServiceMock.createUserFrom(userCreationRequestMock)).thenReturn(userResponseMock);
    }

    @Test
    public void creates_user_correctly() {

        ResponseEntity actual = sut.registerUser(userCreationRequestMock);

        assertThat(actual).isNotNull();
    }
}
