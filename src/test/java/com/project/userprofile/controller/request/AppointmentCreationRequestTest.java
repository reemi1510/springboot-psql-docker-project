package com.project.userprofile.controller.request;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppointmentCreationRequestTest {

    AppointmentCreationRequest appointmentCreationRequest;

    @Test
    public void has_required_fields() {
        appointmentCreationRequest = new AppointmentCreationRequest();
        assertThat(appointmentCreationRequest).hasFieldOrProperty("roleId");
        assertThat(appointmentCreationRequest).hasFieldOrProperty("roleDescription");
        assertThat(appointmentCreationRequest).hasFieldOrProperty("organisationName");
    }
}
