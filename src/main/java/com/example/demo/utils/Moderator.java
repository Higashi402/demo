package com.example.demo.utils;

import com.example.demo.roles.RoleType;

public class Moderator extends User{
    public Moderator(String username, String password) {
        super(username, password, RoleType.MODERATOR);
    }

    @Override
    public void displayRole() {

    }
}
