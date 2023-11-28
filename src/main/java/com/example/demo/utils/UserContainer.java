package com.example.demo.utils;

import com.example.demo.sessionUtils.SessionManager;

import java.util.HashMap;

public class UserContainer {
    public static HashMap <String, User> users = UserFactory.createUserDictionary();

    public static void addBookRequestToUser(User user, Integer id, BookRequest bookRequest) {
        if (user != null && user instanceof RegularUser) {
            RegularUser regularUser = (RegularUser) user;
            regularUser.addApplication(id, bookRequest);
        }
    }
}
