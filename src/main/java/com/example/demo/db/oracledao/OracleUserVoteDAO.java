package com.example.demo.db.oracledao;

import com.example.demo.db.dao.UserVoteDAO;
import com.example.demo.utils.UserVote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleUserVoteDAO implements UserVoteDAO {
    private Connection connection;

    public OracleUserVoteDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }


    @Override
    public float getUserRate(int UserId, int BookId) throws SQLException {
        float rate = 0;
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"USERVOTES\" WHERE \"USERID\" = " + UserId + " AND \"BOOKID\" = " + BookId);
        while (resultSet.next()){
            rate = resultSet.getInt("RATE");
        }
        return rate;
    }

    @Override
    public void updateUserVote(int UserId, int BookId, float rate) throws SQLException {
        Statement statement = this.getConnection().createStatement();
        statement.executeQuery("UPDATE USERVOTES SET RATE = " + rate + "WHERE BOOKID = "+ BookId + " AND USERID = " + UserId);
    }

    @Override
    public void createUserVote(int UserId, int BookId, float rate) throws SQLException {
        Statement statement = this.getConnection().createStatement();
        statement.executeQuery("INSERT INTO USERVOTES(USERID, BOOKID,RATE) VALUES(" + UserId + ", "+ BookId +", " + rate +")");
    }

    @Override
    public UserVote getUserVote(int UserId, int BookId) throws SQLException {
        UserVote userVote = new UserVote();
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"USERVOTES\" WHERE \"USERID\" = " + UserId + " AND \"BOOKID\" = " + BookId);
        while (resultSet.next()){
            userVote.setUserId(resultSet.getInt("USERID"));
            userVote.setBookId(resultSet.getInt("BOOKID"));
            userVote.setUserRate(resultSet.getFloat("RATE"));
            return userVote;
        }
        return null;
    }

    @Override
    public float getAvarageRate(int bookId) throws SQLException {
        float avarageRate = 0;
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT AVG(RATE) AS AVARAGERATE FROM USERVOTES WHERE BOOKID = " + bookId);
        while(resultSet.next()) {
            avarageRate = resultSet.getFloat("AVARAGERATE");
            return avarageRate;
        }
        return 0;
    }

    @Override
    public int getAmountOfVotersByBookId(int bookId) throws SQLException {
        int amountOfVoters;
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(RATE) AS AMOUNT FROM USERVOTES WHERE BOOKID = " + bookId);
        while (resultSet.next()) {
            amountOfVoters = resultSet.getInt("AMOUNT");
            return amountOfVoters;
        }
        return 0;
    }
}
