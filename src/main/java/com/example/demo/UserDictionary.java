package com.example.demo;

import com.example.demo.roles.RoleType;

import java.util.HashMap;
import java.util.Map;

public class UserDictionary {
    private Map<String, String> userPasswords = new HashMap<>();
    private Map<String, RoleType> userRoles = new HashMap<>();

    public UserDictionary() {
        // Инициализация словаря логинов, паролей и ролей
        userPasswords.put("user1", "password1");
        userRoles.put("user1", RoleType.USER);

        userPasswords.put("user2", "password2");
        userRoles.put("user2", RoleType.MODERATOR);

        userPasswords.put("admin", "adminPassword");
        userRoles.put("admin", RoleType.ADMIN);
    }

    public RoleType getUserRole(String login) {
        return userRoles.get(login);
    }

    public String getUserPassword(String login) {
        return userPasswords.get(login);
    }
}
