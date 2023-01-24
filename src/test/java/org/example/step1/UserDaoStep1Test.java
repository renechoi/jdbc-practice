package org.example.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoStep1Test {
    @BeforeEach
    void setUp() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db_schema.sql"));
        DatabasePopulatorUtils.execute(populator, ConnectionMangerStep1.getDataSource());
    }

    @Test
    void createTest() throws SQLException {
        UserDaoStep1 userDaoStep1 = new UserDaoStep1();
        userDaoStep1.create(new User("wizard", "password", "name", "email"));

        User userStep1 = userDaoStep1.findByUserId("wizard");
        assertThat(userStep1).isEqualTo(new User("wizard", "password", "name", "email"));
    }
}
