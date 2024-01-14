package com.example.demo.roles;

public enum RoleType {
    USER(1),
    ADMIN(2),
    MODERATOR(3),
    LIBRARIAN(4);

    private final int id;

    RoleType(int id) {
        this.id = id;
    }

    public static Role getById(int id) {
        for (RoleType roleType : values()) {
            if (roleType.id == id) {
                return new Role(roleType.name());
            }
        }
        return null;
    }
}
