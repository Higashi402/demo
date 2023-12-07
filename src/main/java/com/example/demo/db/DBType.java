package com.example.demo.db;

import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.oracledao.OracleDAOFactory;

public enum DBType {
    ORACLE {
        @Override
        public DAOFactory getDAOFactory() {
            return OracleDAOFactory.getInstance();
        }

    };

    public abstract DAOFactory getDAOFactory();
}
