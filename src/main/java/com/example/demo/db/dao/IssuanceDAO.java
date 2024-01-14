package com.example.demo.db.dao;

import com.example.demo.utils.Issuance;

import java.sql.SQLException;
import java.util.List;

public interface IssuanceDAO {
    List<Issuance> getAllIssuances() throws SQLException;

    Issuance getIssuanceByProposal(int proposalId) throws SQLException;

    void addIssuance(int proposalId) throws SQLException;

    void updateIssuanceDates(String issuanceDate, String returningDate, String issuanceId) throws SQLException;
}


