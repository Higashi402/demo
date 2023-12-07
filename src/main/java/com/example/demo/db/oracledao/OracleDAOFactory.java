package com.example.demo.db.oracledao;

import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.RoleDAO;
import com.example.demo.db.dao.UserDAO;

public class OracleDAOFactory extends DAOFactory {

    private static volatile OracleDAOFactory instance;

    private OracleDAOFactory() {

    }

    public static OracleDAOFactory getInstance() {
        if (instance == null) {
            synchronized (OracleDAOFactory.class) {
                instance = new OracleDAOFactory();
            }
        }
        return instance;
    }

    @Override
    public UserDAO getUserDAO() {
        return new OracleUserDAO();
    }

    @Override
    public RoleDAO getRoleDAO() {
        return new OracleRoleDAO();
    }
}
