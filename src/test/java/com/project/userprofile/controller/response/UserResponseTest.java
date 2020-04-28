package com.project.userprofile.controller.response;

import com.project.userprofile.domain.Appointment;
import com.project.userprofile.domain.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserResponseTest {

    @Test
    public void creates_user_response_correctly() {
        final String expectedEmail = "example@test.com";
        final String expectedFirstName = "Jane";
        final String expectedLastName = "Doe";

        User user = new User(expectedEmail, expectedFirstName, expectedLastName);
        Appointment appointment = new Appointment(1, "Dev", "Org", user);
        user.addAppointment(appointment);

        UserResponse userResponse = new UserResponse(user);

        assertThat(userResponse.getEmail()).isEqualTo(expectedEmail);
        assertThat(userResponse.getFirstName()).isEqualTo(expectedFirstName);
        assertThat(userResponse.getLastName()).isEqualTo(expectedLastName);
        assertThat(userResponse.getAppointments().size()).isEqualTo(1);

    }
}
