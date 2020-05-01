package com.project.userprofile.service;

import com.project.userprofile.controller.request.AppointmentCreationRequest;
import com.project.userprofile.controller.request.UserCreationRequest;
import com.project.userprofile.controller.response.UserResponse;
import com.project.userprofile.domain.Appointment;
import com.project.userprofile.domain.User;
import com.project.userprofile.persistence.AppointmentRepository;
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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    UserRepository userRepositoryMock;
    @Mock
    AppointmentRepository appointmentRepositoryMock;
    @Mock
    User userMock;
    @Mock
    Appointment appointmentMock;

    UserCreationRequest request;
    AppointmentCreationRequest appointmentRequest;

    @InjectMocks
    UserServiceImpl sut;

    @Before
    public void setUp() {

        List<AppointmentCreationRequest> appointments = new ArrayList();
        appointmentRequest = new AppointmentCreationRequest(1, "Dev", "Org");
        appointments.add(appointmentRequest);
        request = new UserCreationRequest("test@email.com", "Jane", "Doe", appointments);


        when(userRepositoryMock.save(any(User.class))).thenReturn(userMock);
        when(appointmentRepositoryMock.save(any(Appointment.class))).thenReturn(appointmentMock);
        when(userMock.getEmail()).thenReturn("test@email.com");
        when(userMock.getFirstName()).thenReturn("Jane");
        when(userMock.getLastName()).thenReturn("Doe");
        when(userMock.getAppointments()).thenReturn(new ArrayList<>());
    }

    @Test
    public void can_save_user_and_appointments_correctly() {

        UserResponse response = sut.createUserFrom(request);

        assertThat(response).isNotNull();
        verify(userRepositoryMock, times(1)).save(any(User.class));
        verify(appointmentRepositoryMock, times(1)).save(any(Appointment.class));

    }

}
