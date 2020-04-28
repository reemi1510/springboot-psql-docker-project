package com.project.userprofile.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AppointmentResponse {

    @JsonProperty("roleId")
    private long roleId;

    @JsonProperty("roleDescription")
    private String roleDesc;

    @JsonProperty("organisationName")
    private String orgName;
}
