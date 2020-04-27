package com.project.userprofile.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class UserTest {

    private String firstName = "Testy";
    private String lastName = "McTestface";
    private String email = "example@test.com";
    User user;

    @Before
    public void setUp() {
        user = new User(email, firstName, lastName);
    }

    @Test
    public void creates_user_correctly() {
        assertThat(user.getFirstName()).isEqualTo(firstName);
        assertThat(user.getLastName()).isEqualTo(lastName);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getId()).isZero();
    }

    @Test
    public void adds_appointments_to_user_correctly() {
        Appointment appointment = mock(Appointment.class);
        user.addAppointment(appointment);

        assertThat(user.getAppointments()).contains(appointment);
    }

    @Test
    public void adds_timestamps_correctly() {
        user.setCreated(LocalDateTime.now());
        user.setLastUpdated(LocalDateTime.now());

        assertThat(user.getCreated()).isNotNull();
        assertThat(user.getLastUpdated()).isNotNull();
    }
}
