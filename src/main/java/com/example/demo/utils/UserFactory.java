package com.example.demo.utils;

import java.util.HashMap;

public class UserFactory {
    public static HashMap<String, User> createUserDictionary() {
        HashMap<String, User> userDictionary = new HashMap<>();

        // Добавление администратора
        Admin admin = new Admin("admin", "1");
        userDictionary.put(admin.getUsername(), admin);

        Moderator moderator = new Moderator("moderator", "1");
        userDictionary.put(moderator.getUsername(), moderator);
        
        // Добавление обычного пользователя
        RegularUser regularUser = new RegularUser("user", "1", false);
        userDictionary.put(regularUser.getUsername(), regularUser);

        RegularUser regularUser1 = new RegularUser("user1", "1", false);
        userDictionary.put(regularUser1.getUsername(), regularUser1);

        // Возврат словаря с пользователями
        return userDictionary;
    }
}