package com.project.userprofile.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppointmentTest {

    @Test
    public void user_has_required_fields() {
        Appointment appointment = new Appointment();
        assertThat(appointment).hasFieldOrProperty("id");
        assertThat(appointment).hasFieldOrProperty("user");
        assertThat(appointment).hasFieldOrProperty("roleId");
        assertThat(appointment).hasFieldOrProperty("roleDesc");
        assertThat(appointment).hasFieldOrProperty("orgName");
    }
}
