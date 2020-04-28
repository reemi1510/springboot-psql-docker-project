package com.project.userprofile.controller.response;

import com.project.userprofile.domain.Appointment;
import com.project.userprofile.domain.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppointmentResponseTest {

    @Test
    public void creates_appointment_response_correctly() {
        final long expectedRoleId = 1;
        final String expectedRoleDesc = "Developer";
        final String expectedOrgName = "Test Org";
        final User user = new User();
        final Appointment appointment = new Appointment(1, "Developer", "Test Org", user);

        AppointmentResponse appointmentResponse = new AppointmentResponse(appointment);

        assertThat(appointmentResponse.getRoleId()).isEqualTo(expectedRoleId);
        assertThat(appointmentResponse.getRoleDesc()).isEqualTo(expectedRoleDesc);
        assertThat(appointmentResponse.getOrgName()).isEqualTo(expectedOrgName);
    }
}
