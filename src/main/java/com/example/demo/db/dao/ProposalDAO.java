package com.example.demo.db.dao;

import com.example.demo.utils.Proposal;

import java.sql.SQLException;
import java.util.List;

public interface ProposalDAO {
    void addProposal(int userId, int bookId) throws SQLException;

    List<Proposal> getProposalsOfUser(int userId) throws SQLException;
}