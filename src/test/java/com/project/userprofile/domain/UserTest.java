package com.project.userprofile.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    public void user_has_required_fields() {
        User user = new User();
        assertThat(user).hasFieldOrProperty("id");
        assertThat(user).hasFieldOrProperty("email");
        assertThat(user).hasFieldOrProperty("firstName");
        assertThat(user).hasFieldOrProperty("lastName");
        assertThat(user).hasFieldOrProperty("created");
        assertThat(user).hasFieldOrProperty("lastUpdated");
        assertThat(user).hasFieldOrProperty("appointments");
    }

    @Test
    public void creates_user_correctly() {
        User user = new User("example@test.com", "Testy", "McTestface");
        assertThat(user.getId()).isZero();
    }

}
