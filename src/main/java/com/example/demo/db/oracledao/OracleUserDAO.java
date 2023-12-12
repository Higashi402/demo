package com.example.demo.db.oracledao;

import com.example.demo.db.dao.UserDAO;
import com.example.demo.roles.RoleType;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleUserDAO implements UserDAO {

    private Connection connection;

    public OracleUserDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }

    private static final String SELECT_WORKER_BY_LOGIN = ConfigurationManager.getProperty("query.select.worker.by.login");

    @Override
    public User getUserByLogin(String login) throws SQLException {
        User user = new User();
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"LIBRARYUSERS\" WHERE \"LOGIN\" = " + "'" + login + "'");
        if (resultSet.next()) {
            user.setId(resultSet.getInt("USERID"));
            user.setUserFIO(resultSet.getString("FIO"));
            user.setUserDOB(resultSet.getDate("USERDOB"));
            user.setUsername(resultSet.getString("LOGIN"));
            user.setPassword(resultSet.getString("USERPASSWORD"));
            user.setBlocked(resultSet.getInt("ISBANED"));
            user.setRole(RoleType.getById(resultSet.getInt("APPOINTMENT")));
            return user;
        } else {
            return null;
        }

    }

    @Override
    public User getUserById(int id) throws SQLException {
        User user = new User();
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"LIBRARYUSERS\" WHERE \"USERID\" = " + "'" + id + "'");
        if (resultSet.next()) {
            user.setId(resultSet.getInt("USERID"));
            user.setUserFIO(resultSet.getString("FIO"));
            user.setUserDOB(resultSet.getDate("USERDOB"));
            user.setUsername(resultSet.getString("LOGIN"));
            user.setPassword(resultSet.getString("USERPASSWORD"));
            user.setBlocked(resultSet.getInt("ISBANED"));
            user.setRole(RoleType.getById(resultSet.getInt("APPOINTMENT")));
            return user;
        } else {
            return null;
        }

    }

  /*  @Override
    public void addUser(String fio, String userDOB, String login, String userPassword, int appointment) throws SQLException {
        String query = "INSERT INTO \"LIBRARYUSERS\" (FIO, USERDOB, LOGIN, USERPASSWORD, APPOINTMENT) VALUES (?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, fio);
            preparedStatement.setString(2, userDOB);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, userPassword);
            preparedStatement.setInt(5, appointment);
            preparedStatement.executeQuery();
        }
    }*/

    @Override
    public void addUser(String fio, String userDOB, String login, String userPassword, int appointment) throws SQLException {
       /* String query = "INSERT INTO \"LIBRARYUSERS\" (FIO, USERDOB, LOGIN, USERPASSWORD, APPOINTMENT) VALUES ('" + fio + "', TO_DATE('" + userDOB + "', 'YYYY-MM-DD'), '" + login + "', '" + userPassword + "', " + appointment + ")";

        try (Connection connection = this.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }*/
        Statement statement = this.getConnection().createStatement();
        statement.executeQuery( "INSERT INTO \"LIBRARYUSERS\" (FIO, USERDOB, LOGIN, USERPASSWORD, APPOINTMENT) VALUES ('" + fio + "', TO_DATE('" + userDOB + "', 'YYYY-MM-DD'), '" + login + "', '" + userPassword + "', " + appointment + ")");

    }

    @Override
    public void updateUser(int userID, String fio, String userDOB, String login, String userPassword, int appointment) throws SQLException {
       /* String query = "INSERT INTO \"LIBRARYUSERS\" (FIO, USERDOB, LOGIN, USERPASSWORD, APPOINTMENT) VALUES ('" + fio + "', TO_DATE('" + userDOB + "', 'YYYY-MM-DD'), '" + login + "', '" + userPassword + "', " + appointment + ")";

        try (Connection connection = this.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }*/
        Statement statement = this.getConnection().createStatement();
        statement.executeQuery( "UPDATE \"LIBRARYUSERS\" SET " +
                "FIO = '" + fio + "', " +
                "USERDOB = TO_DATE('" + userDOB + "', 'YYYY-MM-DD'), " +
                "LOGIN = '" + login + "', " +
                "USERPASSWORD = '" + userPassword + "', " +
                "APPOINTMENT = " + appointment +
                " WHERE USERID = " + userID);

    }

    @Override
    public void deleteUser(int id) throws SQLException {
        Statement statement = this.getConnection().createStatement();
        Statement statement1 = this.getConnection().createStatement();
        statement1.executeQuery("DELETE FROM BOOKPROPOSAL WHERE LIBRARYUSER =" + id);
        statement.executeQuery("DELETE FROM LIBRARYUSERS WHERE USERID =" + id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"LIBRARYUSERS\"");
        User user = new User();
        while(resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("USERID"));
            user.setUserFIO(resultSet.getString("FIO"));
            user.setUserDOB(resultSet.getDate("USERDOB"));
            user.setUsername(resultSet.getString("LOGIN"));
            user.setPassword(resultSet.getString("USERPASSWORD"));
            user.setBlocked(resultSet.getInt("ISBANED"));
            user.setRole(RoleType.getById(resultSet.getInt("APPOINTMENT")));
            users.add(user);
        }
        return users;
    }

}
