package com.project.userprofile.controller.request;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class UserCreationRequestTest {

    UserCreationRequest userCreationRequest;
    private String email = "example@test.com";
    private String firstName = "Jane";
    private String lastName = "Doe";
    private List<AppointmentCreationRequest> appointments = new ArrayList<>();
    private AppointmentCreationRequest appointment = new AppointmentCreationRequest(1, "Dev", "Test");
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void creates_user_request_correctly() {
        appointments.add(appointment);
        userCreationRequest = new UserCreationRequest(email, firstName, lastName,appointments);
        assertThat(userCreationRequest.getEmail()).isEqualTo(email);
        assertThat(userCreationRequest.getFirstName()).isEqualTo(firstName);
        assertThat(userCreationRequest.getLastName()).isEqualTo(lastName);
        assertThat(userCreationRequest.getAppointments()).contains(appointment);
    }

    @Test
    public void buildMethodTest() {
        appointments.add(appointment);

        userCreationRequest = UserCreationRequest.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .appointments(appointments)
                .build();

        assertThat(userCreationRequest.getEmail()).isEqualTo(email);
        assertThat(userCreationRequest.getFirstName()).isEqualTo(firstName);
        assertThat(userCreationRequest.getLastName()).isEqualTo(lastName);
        assertThat(userCreationRequest.getAppointments()).contains(appointment);
    }

    @Test
    public void has_mandatory_field() {
        userCreationRequest = UserCreationRequest.builder()
                .email(null)
                .firstName(firstName)
                .lastName(lastName)
                .appointments(appointments)
                .build();

        Set<ConstraintViolation<UserCreationRequest>> violations = validator.validate(userCreationRequest);
        assertThat(violations.size()).isEqualTo(2);
    }
}
