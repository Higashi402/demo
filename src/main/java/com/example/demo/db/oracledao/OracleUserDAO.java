package com.example.demo.db.oracledao;

import com.example.demo.db.dao.UserDAO;
import com.example.demo.roles.RoleType;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.User;

import java.sql.*;
import java.util.ArrayList;

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
            user.setUsername(resultSet.getString("LOGIN"));
            user.setPassword(resultSet.getString("USERPASSWORD"));
            user.setBlocked(resultSet.getInt("ISBANED"));
            user.setRole(RoleType.getById(resultSet.getInt("APPOINTMENT")));
            return user;
        } else {
            return null;
        }

    }
}
