package com.example.demo.db;

import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.oracledao.OracleDAOFactory;

import java.sql.SQLException;

public enum DBType {
    ORACLE {
        @Override
        public DAOFactory getDAOFactory(){
            DAOFactory oracleDAOFactory = null;
            try {
                oracleDAOFactory = OracleDAOFactory.getInstance();
                System.out.println("DAOFactory.getDAOFactory()");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return oracleDAOFactory;
        }

    };

    public abstract DAOFactory getDAOFactory();
}
