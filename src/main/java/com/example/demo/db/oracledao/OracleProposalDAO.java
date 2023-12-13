package com.example.demo.db.oracledao;

import com.example.demo.db.dao.ProposalDAO;
import com.example.demo.utils.Book;
import com.example.demo.utils.Proposal;
import com.example.demo.utils.RequestStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleProposalDAO implements ProposalDAO {

    private Connection connection;

    public OracleProposalDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void addProposal(int userId, int bookId) throws SQLException {
        Statement statement = this.getConnection().createStatement();
        statement.executeQuery("INSERT INTO BookProposal (LibraryUser, Book, Status, ReturningDate) VALUES (" + userId + ", " + bookId + ", 'В рассмотрении', TO_DATE('2023/05/23', 'yyyy/mm/dd'))");
    }

    @Override
    public List<Proposal> getProposalsOfUser(int userId) throws SQLException {
        List<Proposal> proposals = new ArrayList<>();
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM BOOKPROPOSAL JOIN BOOKS ON bookproposal.book = books.bookid \n" +
                "WHERE LIBRARYUSER =" + userId);
        Proposal proposal = null;
        while (resultSet.next()) {
            proposal = new Proposal();
            proposal.setId(resultSet.getInt("PROPOSALID"));
            proposal.setBookId(resultSet.getInt("BOOKID"));
            proposal.setBookTitle(resultSet.getString("TITLE"));
            proposal.setAuthor(resultSet.getString("AUTHOR"));
            proposal.setProposalStatus(resultSet.getString("STATUS"));
            proposals.add(proposal);
        }

        return proposals;
    }

    @Override
    public Proposal getProposalById(int proposalId) throws SQLException {
        Proposal proposal = new Proposal();
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM BOOKPROPOSAL JOIN BOOKS ON bookproposal.book = books.bookid \n" +
                "WHERE PROPOSALID =" + proposalId);
        if (resultSet.next()) {
            proposal = new Proposal();
            proposal.setId(resultSet.getInt("PROPOSALID"));
            proposal.setLibraryUserId(resultSet.getInt("LIBRARYUSER"));
            proposal.setBookTitle(resultSet.getString("TITLE"));
            proposal.setProposalStatus(resultSet.getString("STATUS"));
            proposal.setAuthor(resultSet.getString("AUTHOR"));
        }
        return proposal;
    }

    @Override
    public void deleteProposalById(int proposalId) throws SQLException {
        Statement statement = this.getConnection().createStatement();
        statement.executeQuery("DELETE FROM BOOKPROPOSAL WHERE PROPOSALID =" + proposalId);
    }

    @Override
    public void changeProposalStatus(String status, int proposalID) throws SQLException {
        Connection connection = this.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE BOOKPROPOSAL SET STATUS = ? WHERE PROPOSALID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, Integer.toString(proposalID));
            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
