package com.project.userprofile.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.userprofile.domain.User;
import lombok.Getter;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class UserResponse {

    @JsonProperty
    private final String email;

    @JsonProperty
    private final String firstName;

    @JsonProperty
    private final String lastName;

    @JsonProperty
    private final List<AppointmentResponse> appointments;

    public UserResponse(User user) {
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.appointments = user.getAppointments()
                .stream()
                .map(appointment -> new AppointmentResponse(appointment))
                .collect(toList());
    }
}
