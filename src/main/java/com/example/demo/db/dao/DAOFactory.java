package com.example.demo.db.dao;

import com.example.demo.db.DBType;

public abstract class DAOFactory {

    public static DAOFactory getInstance(DBType type) {
        return type.getDAOFactory();
    }

    public abstract UserDAO getUserDAO();

    public abstract RoleDAO getRoleDAO();
}
