package com.example.demo.utils;

import com.example.demo.roles.RoleType;

class Admin extends User {
    public Admin(String username, String password) {
        super(username, password, RoleType.ADMIN);
    }

    // Переопределение метода displayRole для администратора
    @Override
    public void displayRole() {
        System.out.println("Admin: " + super.getUsername());
    }
}
