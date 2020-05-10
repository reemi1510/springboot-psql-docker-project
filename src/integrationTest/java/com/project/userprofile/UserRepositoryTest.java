package com.project.userprofile;

import com.project.userprofile.domain.User;
import com.project.userprofile.persistence.UserRepository;
import com.project.userprofile.util.FunctionalTestsContainer;
import org.flywaydb.core.Flyway;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @ClassRule
    public static PostgreSQLContainer container = FunctionalTestsContainer.getInstance();

    @Autowired
    protected UserRepository userRepository;

    @BeforeClass
    public static void setUp() {
        Flyway flyway = Flyway.configure().dataSource(container.getJdbcUrl(), container.getUsername(), container.getPassword()).load();
        flyway.migrate();

        System.out.println(container.getLogs());
    }

    @Test
    public void persists_valid_new_users() {
        userRepository.save(new User("user1@test.com", "User", "One"));
        userRepository.save(new User("user2@test.com", "User", "Two"));

        long count = userRepository.count();

        assertThat(count).isEqualTo(2L);
    }

    @Test
    public void persists_each_user_with_unique_id() throws IOException, InterruptedException {
        User user1 = userRepository.save(new User("User1@test.com", "User", "One"));
        User user2 = userRepository.save(new User("User2@test.com", "User", "Two"));

        User persistedUser1 = userRepository.getOne(user1.getId());
        User persistedUser2 = userRepository.getOne(user2.getId());

        assertThat(persistedUser1).isEqualTo(user1);
        assertThat(persistedUser2).isEqualTo(user2);
        assertThat(persistedUser1.getId()).isNotEqualTo(persistedUser2.getId());
    }
}
