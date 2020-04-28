package com.project.userprofile.controller.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
public class UserCreationRequest {

    @NotNull
    @NotEmpty
    private String email;

    private String firstName;

    private String lastName;

    private List<AppointmentCreationRequest> appointments;

    @JsonCreator
    public UserCreationRequest(
            @JsonProperty("email") String email,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("appointments") List<AppointmentCreationRequest> appointments) {

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.appointments = appointments;
    }
}
