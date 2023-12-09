package com.example.demo.db.dao;

import com.example.demo.utils.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO {
    User getUserByLogin(String login) throws SQLException;
}
