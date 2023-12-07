package com.example.demo.db.oracledao;

import com.example.demo.db.ConnectionPool;
import com.example.demo.db.dao.UserDAO;
import com.example.demo.roles.RoleType;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OracleUserDAO implements UserDAO {

    private static final String SELECT_WORKER_BY_LOGIN = ConfigurationManager.getProperty("query.select.worker.by.login");

    @Override
    public User getUserByLogin(String login) {
        User user = null;

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WORKER_BY_LOGIN);
            preparedStatement.setString(1, login);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = giveUser(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }

    private User giveUser(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getInt("USERID"));
        user.setUsername(resultSet.getString("LOGIN"));
        user.setPassword(resultSet.getString("USERPASSWORD"));
        user.setRole(RoleType.getRole(resultSet.getInt("APPOINTMENT")));
        user.setBlocked(resultSet.getInt("ISBANED"));

        return user;
    }
}
