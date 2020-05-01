package com.project.userprofile.service;

import com.project.userprofile.controller.request.UserCreationRequest;
import com.project.userprofile.controller.response.UserResponse;
import com.project.userprofile.domain.User;
import com.project.userprofile.persistence.UserRepository;
import com.project.userprofile.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    UserRepository userRepositoryMock;
    @Mock
    User userMock;

    UserCreationRequest request;

    @InjectMocks
    UserServiceImpl sut;

    @Before
    public void setUp() {

        List appointments = new ArrayList();
        request = new UserCreationRequest("test@email.com", "Jane", "Doe", appointments);

        when(userRepositoryMock.save(any(User.class))).thenReturn(userMock);
        when(userMock.getEmail()).thenReturn("test@email.com");
        when(userMock.getFirstName()).thenReturn("Jane");
        when(userMock.getLastName()).thenReturn("Doe");
        when(userMock.getAppointments()).thenReturn(appointments);
    }

    @Test
    public void can_create_user_from_request_and_save() {

        UserResponse response = sut.createUserFrom(request);

        assertThat(response).isNotNull();
    }
}
