package com.example.demo.roles;

import java.util.Objects;

public class Role{
    private String roleName;

    public Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    // Геттер для получения имени роли
    public String getRoleName() {
        return roleName;
    }

    // Сеттер для установки имени роли (если необходимо)
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
