package com.example.demo.db.dao;

import com.example.demo.utils.User;

import java.util.ArrayList;

public interface UserDAO {
    User getUserByLogin(String login);
}
