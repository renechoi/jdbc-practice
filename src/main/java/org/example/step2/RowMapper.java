package org.example.step2;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {
    Object mapRow(ResultSet resultSet) throws SQLException;
}
