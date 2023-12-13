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
    public User getUserByID(int userID) throws SQLException {
        User user = new User();
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"LIBRARYUSERS\" WHERE \"USERID\" = " + "'" + userID + "'");
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
    public void addUser(String fio, String userDOB, String login, String userPassword, int appointment) throws SQLException {
        Statement statement = this.getConnection().createStatement();
        statement.executeQuery( "INSERT INTO \"LIBRARYUSERS\" (FIO, USERDOB, LOGIN, USERPASSWORD, APPOINTMENT) VALUES ('" + fio + "', TO_DATE('" + userDOB + "', 'YYYY-MM-DD'), '" + login + "', '" + userPassword + "', " + appointment + ")");

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
