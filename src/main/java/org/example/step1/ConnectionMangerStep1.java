package org.example.step1;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
public class ConnectionMangerStep1 {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PW = "";
    private static final int MAX_POOL_SIZE = 40;

    public static DataSource getDataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(DB_URL);
        hikariDataSource.setJdbcUrl("jdbc:h2:");
        hikariDataSource.setUsername("sa");
        hikariDataSource.setUsername("");

        return hikariDataSource;
    }
}
