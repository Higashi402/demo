package com.example.demo.utils;

import com.example.demo.roles.RoleType;

import java.util.HashMap;

public class RegularUser extends User {
    private HashMap<Integer, BookRequest> bookRequests = new HashMap<>();

    private boolean isBlocked;

    public RegularUser(String username, String password, boolean isBlocked) {
        super(username, password, RoleType.USER);
        this.bookRequests = new HashMap<>();
        this.isBlocked = isBlocked;

    }

    // Геттер и сеттер для applications
    public HashMap<Integer, BookRequest> getApplications() {
        return bookRequests;
    }

    public boolean getBlocked() {
        return this.isBlocked;
    }

    public void setBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }
    public void setApplications(HashMap<Integer, BookRequest> bookRequests) {
        this.bookRequests = bookRequests;
    }

    // Метод для добавления заявки пользователю
    public void addApplication(Integer key, BookRequest value) {
        bookRequests.put(key, value);
    }

    public void removeApplication(Integer key, BookRequest value) {
        bookRequests.remove(key);
    }

    // Переопределение метода displayRole для обычного пользователя
    @Override
    public void displayRole() {
        System.out.println("Regular User: " + super.getUsername());
    }
}
