package com.project.userprofile.controller.request;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppointmentCreationRequestTest {

    private AppointmentCreationRequest appointmentCreationRequest;
    private long roleId = 1;
    private String roleDescription = "Developer";
    private String organisationName = "Test Org";

    @Test
    public void creates_appointment_request_correctly() {
        appointmentCreationRequest = new AppointmentCreationRequest(roleId, roleDescription, organisationName);
        assertThat(appointmentCreationRequest.getRoleId()).isEqualTo(roleId);
        assertThat(appointmentCreationRequest.getRoleDesc()).isEqualTo(roleDescription);
        assertThat(appointmentCreationRequest.getOrgName()).isEqualTo(organisationName);
    }

    @Test
    public void buildMethodTest() {
        appointmentCreationRequest = AppointmentCreationRequest.builder()
                .roleId(roleId)
                .roleDesc(roleDescription)
                .orgName(organisationName)
                .build();

        assertThat(appointmentCreationRequest.getRoleId()).isEqualTo(roleId);
        assertThat(appointmentCreationRequest.getRoleDesc()).isEqualTo(roleDescription);
        assertThat(appointmentCreationRequest.getOrgName()).isEqualTo(organisationName);
    }
}
