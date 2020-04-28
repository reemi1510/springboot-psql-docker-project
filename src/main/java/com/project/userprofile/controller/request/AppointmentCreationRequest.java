package com.project.userprofile.controller.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AppointmentCreationRequest {

    private long roleId;

    private String roleDesc;

    private String orgName;

    @JsonCreator
    public AppointmentCreationRequest(
            @JsonProperty("roleId") long roleId,
            @JsonProperty("roleDescription") String roleDesc,
            @JsonProperty("organisationName") String orgName) {

        this.roleId = roleId;
        this.roleDesc = roleDesc;
        this.orgName = orgName;
    }
}
