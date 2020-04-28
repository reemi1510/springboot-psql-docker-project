package com.project.userprofile.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class UserResponse {

    @JsonProperty
    private String email;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private List<AppointmentResponse> appointments;
}
