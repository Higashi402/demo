package com.example.demo.db.dao;

import com.example.demo.utils.UserVote;

import java.sql.SQLException;

public interface UserVoteDAO {
    float getUserRate(int UserId, int BookId) throws SQLException;

    void updateUserVote(int UserId, int BookId, float rate) throws SQLException;

    void createUserVote(int UserId, int BookId, float rate) throws SQLException;

    UserVote getUserVote(int UserId, int BookId) throws SQLException;

    float getAvarageRate(int bookId) throws SQLException;

    int getAmountOfVotersByBookId(int bookId) throws SQLException;
}
