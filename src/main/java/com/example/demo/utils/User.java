package com.example.demo.utils;

import com.example.demo.roles.Role;
import com.example.demo.roles.RoleType;

public class User {
    private int id;
    private String username;
    private String password;
    private Role role;
    private int blocked;

    public User(){}

    public User(int id, String username, String password, Role role, int blocked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.blocked = blocked;
    }

    public User(String username, String password, Role role, int blocked) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.blocked = blocked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Role getRole() {
        return role;
    }

    public String getRoleName() {
        return role.getRoleName();
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getBlocked() {
        return blocked;
    }

    public void setBlocked(int blocked) {
        this.blocked = blocked;
    }

}
