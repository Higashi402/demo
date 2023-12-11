package com.example.demo.utils;

import com.example.demo.roles.Role;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private Role role;

    private Date userDOB;
    private int blocked;

    private String userFIO;

    public User(){}

    public User(int id,String userFIO, Date userDOB, String username, String password, Role role, int blocked) {
        this.userFIO = userFIO;
        this.id = id;
        this.userDOB = userDOB;
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

    public String getUserFIO(){return  userFIO;};

    public void setUserFIO(String userFIO) {this.userFIO = userFIO;}

    public Date getUserDOB() {return userDOB;}

    public void setUserDOB(Date userAge) {this.userDOB = userAge;}


}
