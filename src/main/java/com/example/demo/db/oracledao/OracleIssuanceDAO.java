package com.example.demo.db.oracledao;

import com.example.demo.db.dao.IssuanceDAO;
import com.example.demo.utils.Book;
import com.example.demo.utils.Issuance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleIssuanceDAO implements IssuanceDAO {

    private Connection connection;

    public OracleIssuanceDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public List<Issuance> getAllIssuances() throws SQLException {
        List<Issuance> issuances = new ArrayList<>();
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM ((BOOKISSUANCE JOIN BOOKPROPOSAL ON BOOKISSUANCE.BOOKPROPOSAL = BOOKPROPOSAL.PROPOSALID) JOIN LIBRARYUSERS ON LIBRARYUSER = LIBRARYUSERS.USERID) JOIN BOOKS ON BOOK = BOOKS.BOOKID");
        Issuance issuance = new Issuance();
        while(resultSet.next()) {
            issuance = new Issuance();
            issuance.setBookProposal(resultSet.getInt("BOOKPROPOSAL"));
            issuance.setIssuanceDate(resultSet.getString("ISSUANCEDATE"));
            issuance.setActualReturningDate(resultSet.getString("ACTUALRETURNINGDATE"));
            issuance.setUserLogin(resultSet.getString("LOGIN"));
            issuance.setBookTitle(resultSet.getString("TITLE"));
            issuance.setAuthor(resultSet.getString("AUTHOR"));
            issuances.add(issuance);
        }
        return issuances;
    }

    @Override
    public Issuance getIssuanceByProposal(int proposalId) throws SQLException {
        Issuance issuance = new Issuance();
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM ((BOOKISSUANCE JOIN BOOKPROPOSAL ON BOOKISSUANCE.BOOKPROPOSAL = BOOKPROPOSAL.PROPOSALID) JOIN LIBRARYUSERS ON LIBRARYUSER = LIBRARYUSERS.USERID) JOIN BOOKS ON BOOK = BOOKS.BOOKID WHERE PROPOSALID = " + proposalId);
        while(resultSet.next()) {
            issuance.setBookProposal(resultSet.getInt("BOOKPROPOSAL"));
            issuance.setIssuanceDate(resultSet.getString("ISSUANCEDATE"));
            issuance.setActualReturningDate(resultSet.getString("ACTUALRETURNINGDATE"));
            issuance.setUserLogin(resultSet.getString("LOGIN"));
            issuance.setBookTitle(resultSet.getString("TITLE"));
            issuance.setAuthor(resultSet.getString("AUTHOR"));
            return issuance;
        }
        return null;
    }

    @Override
    public void addIssuance(int proposalId) throws SQLException {
        Statement statement = this.getConnection().createStatement();
        statement.executeQuery("INSERT INTO BOOKISSUANCE(BOOKPROPOSAL) VALUES(" + proposalId + ")");
    }

    @Override
    public void updateIssuanceDates(String issuanceDate, String returningDate, String issuanceId) throws SQLException {
        Statement statement = this.getConnection().createStatement();
        statement.executeQuery("UPDATE BOOKISSUANCE SET ISSUANCEDATE = TO_DATE('" + issuanceDate + "', 'YYYY-MM-DD')," + "ACTUALRETURNINGDATE = TO_DATE('" + returningDate + "', 'YYYY-MM-DD') WHERE BOOKPROPOSAL = " + issuanceId);
    }
}
