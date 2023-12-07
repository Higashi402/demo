package com.example.demo.db.oracledao;

import com.example.demo.db.ConnectionPool;
import com.example.demo.db.dao.RoleDAO;
import com.example.demo.roles.Role;
import com.example.demo.utils.ConfigurationManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleRoleDAO implements RoleDAO {

    private static final String SELECT_ROLE_BY_ID = ConfigurationManager.getProperty("query.select.role.by.id");

    @Override
    public Role getRoleById(int id) {
        Role role = null;

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                role = new Role(id, rs.getString(2));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return role;
    }
}
