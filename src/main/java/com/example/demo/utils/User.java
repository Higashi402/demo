package com.example.demo.utils;

import com.example.demo.roles.RoleType;

public abstract class User {
    private String username;
    private String password;
    private RoleType role;

    // Конструктор класса User
    public User(String username, String password, RoleType role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Геттеры и сеттеры для атрибутов
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(String RoleType) {
        this.role = role;
    }

    // Абстрактный метод для отображения роли пользователя
    public abstract void displayRole();
}
