package com.example.demo.db.dao;

import com.example.demo.db.DBType;

public abstract class DAOFactory {

    public static DAOFactory getInstance(DBType type) {
        DAOFactory result = type.getDAOFactory();
        System.out.println("DAOFactory.getInstance()");
        return result;
    }

    public abstract UserDAO getUserDAO();

    public abstract RoleDAO getRoleDAO();

    public abstract BookDAO getBookDAO();

    public abstract ProposalDAO getProposalDAO();

    public abstract IssuanceDAO getIssuanceDAO();

    public abstract UserVoteDAO getUserVoteDAO();
}
