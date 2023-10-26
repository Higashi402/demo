package com.example.demo.roles;

public enum RoleType {
    USER(1),
    SYS_ADMIN(2),
    MODERATOR(3),
    ADMIN(4);

    private final int id;

    RoleType(int id) {
        this.id = id;
    }

    public Role getRole() {
        return getRole(id);
    }

    public static Role getRole(int id) {
        return null;
    }
}
