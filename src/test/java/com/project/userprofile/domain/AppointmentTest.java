package com.project.userprofile.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class AppointmentTest {

    private long roleId = 1;
    private String roleDesc = "Developer";
    private String orgName = "Test Org";
    User mockUser;
    Appointment appointment;

    @Before
    public void setUp() {
        mockUser = mock(User.class);
        appointment = new Appointment(roleId, roleDesc, orgName, mockUser);
    }

    @Test
    public void creates_appointment_correctly() {
        assertThat(appointment.getRoleId()).isEqualTo(roleId);
        assertThat(appointment.getRoleDesc()).isEqualTo(roleDesc);
        assertThat(appointment.getOrgName()).isEqualTo(orgName);
        assertThat(appointment.getUser()).isEqualTo(mockUser);
        assertThat(appointment.getId()).isZero();
    }

}
