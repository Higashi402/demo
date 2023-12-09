package com.example.demo.db.dao;

import com.example.demo.roles.Role;

import java.sql.SQLException;

public interface RoleDAO {

    Role getRoleByTitle(String title) throws SQLException;

}
