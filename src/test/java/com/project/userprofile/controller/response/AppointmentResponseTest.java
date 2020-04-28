package com.project.userprofile.controller.response;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppointmentResponseTest {

    AppointmentResponse appointmentResponse;

    @Test
    public void has_required_fields() {
        appointmentResponse = new AppointmentResponse();

        assertThat(appointmentResponse).hasFieldOrProperty("roleId");
        assertThat(appointmentResponse).hasFieldOrProperty("roleDesc");
        assertThat(appointmentResponse).hasFieldOrProperty("orgName");
    }
}
