package com.project.userprofile.controller.request;

import java.util.List;

public class UserCreationRequest {

    private String email;

    private String firstName;

    private String lastName;

    private List<AppointmentCreationRequest> appointments;

}
