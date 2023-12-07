package com.example.demo.roles;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.DAOFactory;

public enum RoleType {
    USER(1),
    LIBRARIAN(2),
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
        return DAOFactory.getInstance(DBType.ORACLE).getRoleDAO().getRoleById(id);
    }
}
