package com.example.demo;

import com.example.demo.roles.RoleType;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UserDictionary {
    private static final Map<String, String> userPasswords = initPasswords();
    private static final Map<String, RoleType> userRoles = initRoles();

    public UserDictionary() {
        // Инициализация словаря логинов, паролей и ролей
        /*userPasswords.put("user1", "password1");
        userRoles.put("user1", RoleType.USER);

        userPasswords.put("user2", "password2");
        userRoles.put("user2", RoleType.MODERATOR);

        userPasswords.put("admin", "adminPassword");
        userRoles.put("admin", RoleType.ADMIN);*/
    }

    public static RoleType getUserRole(String login) {
        return userRoles.get(login);
    }

    public static Map<String, String> initPasswords() {
        Map<String, String> result = new HashMap<>();
        result.put("user1", "1");
        result.put("user2", "1");
        result.put("user3", "1");
        result.put("user4", "1");
        result.put("admin", "1");
        return result;
    }

    public static Map<String, RoleType> initRoles() {
        Map<String, RoleType> result = new HashMap<>();
        result.put("user1", RoleType.USER);
        result.put("user2", RoleType.USER);
        result.put("user3", RoleType.USER);
        result.put("user4", RoleType.MODERATOR);
        result.put("admin", RoleType.ADMIN);
        return result;
    }

    public static String getUserPassword(String login) {
        return userPasswords.get(login);
    }

    public static Map<String, RoleType> filterUsers(Map<String, RoleType> dictionary) {
        return dictionary.entrySet().stream()
                .filter(entry -> entry.getValue() == RoleType.USER)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    public static Map<String, RoleType> getUsers() {
        return filterUsers(userRoles);
    }
}
