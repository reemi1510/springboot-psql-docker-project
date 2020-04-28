package com.project.userprofile.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.userprofile.domain.Appointment;
import lombok.Getter;

@Getter
public class AppointmentResponse {

    @JsonProperty("roleId")
    private long roleId;

    @JsonProperty("roleDescription")
    private String roleDesc;

    @JsonProperty("organisationName")
    private String orgName;

    public AppointmentResponse(Appointment appointment) {
        this.roleId = appointment.getRoleId();
        this.roleDesc = appointment.getRoleDesc();
        this.orgName = appointment.getOrgName();
    }
}
