package com.example.demo.utils;

import com.example.demo.roles.RoleType;

import java.util.HashMap;
import java.util.Map;

public class RegularUser extends User {
    private HashMap<Integer, BookRequest> bookRequests = new HashMap<>();

    public RegularUser(String username, String password) {
        super(username, password, RoleType.USER);
        this.bookRequests = new HashMap<>();
    }

    // Геттер и сеттер для applications
    public HashMap<Integer, BookRequest> getApplications() {
        return bookRequests;
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
