package com.example.demo.db.oracledao;

import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.RoleDAO;
import com.example.demo.db.dao.UserDAO;
import com.example.demo.db.dao.BookDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class OracleDAOFactory extends DAOFactory {

    private static volatile OracleDAOFactory instance;
    private Connection connection;

    private OracleDAOFactory() {}

    public static OracleDAOFactory getInstance() throws SQLException, ClassNotFoundException {
        OracleDAOFactory factory = instance;
        if (instance == null) {
            synchronized (OracleDAOFactory.class) {
                instance = factory;
                factory = new OracleDAOFactory();
                factory.connected();
            }
        }
        return factory;
    }

    private void connected() throws ClassNotFoundException, SQLException {
        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "sys as sysdba";
        String password = "12345";
        Class.forName("oracle.jdbc.OracleDriver");

        connection = DriverManager.getConnection(url, user, password);
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public UserDAO getUserDAO() {
        return new OracleUserDAO(connection);
    }

    @Override
    public RoleDAO getRoleDAO() {
        return new OracleRoleDAO(connection);
    }

    @Override
    public BookDAO getBookDAO() {
        return new OracleBookDAO(connection);
    }
}
