package org.example.step1;

import java.sql.*;

public class UserDaoStep1 {


    private Connection getConnection() {
        String url = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
        String id = "sa";
        String pw = "";

        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            return null;
        }

    }

    public void create(User userStep1) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String sql = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userStep1.getUserId());
            preparedStatement.setString(2, userStep1.getPassword());
            preparedStatement.setString(3, userStep1.getName());
            preparedStatement.setString(4, userStep1.getEmail());

            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }

    public User findByUserId(String userId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String sql = "SELECT userId, password, name eamil FROM USERS WHERE userId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userId);

            resultSet = preparedStatement.executeQuery();
            User userStep1 = null;

            if (resultSet.next()){
                userStep1 = new User(resultSet.getString("userId"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("email"));
            }
            return userStep1;
        } finally {
            if (resultSet != null){
                resultSet.close();
            }

            if (preparedStatement != null){
                preparedStatement.close();
            }

            if (connection != null){
                connection.close();
            }
        }
    }
}
