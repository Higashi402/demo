package com.example.demo.db.oracledao;

import com.example.demo.db.dao.RoleDAO;
import com.example.demo.roles.Role;
import com.example.demo.utils.ConfigurationManager;

import java.sql.*;

public class OracleRoleDAO implements RoleDAO {

    private Connection connection;

    public OracleRoleDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }

    private static final String SELECT_ROLE_BY_ID = ConfigurationManager.getProperty("query.select.role.by.id");

    @Override
    public Role getRoleByTitle(String role_title) throws SQLException {
        Role role = new Role();
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"ROLE\" WHERE \"TITLE\" = " + "'" + role_title + "'");
        if (resultSet.next()) {
            //role.setRoleId(resultSet.getInt("ROLE_ID"));
        }
        return role;
    }
}
