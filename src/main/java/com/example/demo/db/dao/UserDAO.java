package com.example.demo.db.dao;

import com.example.demo.utils.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDAO {
    User getUserByLogin(String login) throws SQLException;

    void addUser(String fio, String userDOB, String login, String userPassword, int appointment) throws SQLException;

    List <User> getAllUsers() throws SQLException;

    User getUserByID(int userID) throws SQLException;

    void blockUser(int userId) throws SQLException;

    void unBlockUser(int userId) throws SQLException;

    void updateUser(int id, String fio, String userDOB, String login, String userPassword, int appointment) throws SQLException;

    void deleteUser(int id) throws SQLException;
}
