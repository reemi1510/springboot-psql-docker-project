package com.project.userprofile.controller.request;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserCreationRequestTest {

    UserCreationRequest userCreationRequest;
    private String email = "example@test.com";
    private String firstName = "Jane";
    private String lastName = "Doe";
    private List<AppointmentCreationRequest> appointments = new ArrayList<>();
    private AppointmentCreationRequest appointment = new AppointmentCreationRequest(1, "Dev", "Test");

    @Test
    public void creates_user_request_correctly() {
        appointments.add(appointment);
        userCreationRequest = new UserCreationRequest(email, firstName, lastName,appointments);
        assertThat(userCreationRequest.getEmail()).isEqualTo(email);
        assertThat(userCreationRequest.getFirstName()).isEqualTo(firstName);
        assertThat(userCreationRequest.getLastName()).isEqualTo(lastName);
        assertThat(userCreationRequest.getAppointments()).contains(appointment);
    }
}
