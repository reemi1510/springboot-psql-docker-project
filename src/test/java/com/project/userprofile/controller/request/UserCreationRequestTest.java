package com.project.userprofile.controller.request;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserCreationRequestTest {

    UserCreationRequest userCreationRequest;

    @Test
    public void has_required_fields() {
        userCreationRequest = new UserCreationRequest();
        assertThat(userCreationRequest).hasFieldOrProperty("email");
        assertThat(userCreationRequest).hasFieldOrProperty("firstName");
        assertThat(userCreationRequest).hasFieldOrProperty("lastName");
        assertThat(userCreationRequest).hasFieldOrProperty("appointments");
    }
}
