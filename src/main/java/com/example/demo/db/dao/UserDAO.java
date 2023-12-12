package com.example.demo.db.dao;

import com.example.demo.utils.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDAO {
    User getUserByLogin(String login) throws SQLException;


    User getUserById(int id) throws SQLException;

    void addUser(String fio, String userDOB, String login, String userPassword, int appointment) throws SQLException;

    void updateUser(int userID, String fio, String userDOB, String login, String userPassword, int appointment) throws SQLException;

    void deleteUser(int id) throws SQLException;

    List <User> getAllUsers() throws SQLException;
}
