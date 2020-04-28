package com.project.userprofile.controller.response;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserResponseTest {

    UserResponse userResponse;

    @Test
    public void has_required_fields() {
        userResponse = new UserResponse();
        assertThat(userResponse).hasFieldOrProperty("email");
        assertThat(userResponse).hasFieldOrProperty("firstName");
        assertThat(userResponse).hasFieldOrProperty("lastName");
        assertThat(userResponse).hasFieldOrProperty("appointments");
    }
}
