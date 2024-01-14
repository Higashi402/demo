package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.*;
import com.example.demo.utils.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UpdateRequestStatusCommand extends Command {

    private static DAOFactory daoFactory = null;

    public BookDAO bookDAO;
    public ProposalDAO proposalDAO;
    public UserDAO userDAO;
    public IssuanceDAO issuanceDAO;

    static {
        daoFactory = DAOFactory.getInstance(DBType.ORACLE);
    }

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        bookDAO = daoFactory.getBookDAO();
        proposalDAO = daoFactory.getProposalDAO();
        userDAO = daoFactory.getUserDAO();
        issuanceDAO = daoFactory.getIssuanceDAO();
    }

    @Override
    public void send() throws ServletException, IOException, SQLException {
        int proposalId = Integer.parseInt(request.getParameter("id"));
        Proposal proposal = this.proposalDAO.getProposalById(proposalId);
        RequestStatus status = RequestStatus.valueOf(request.getParameter("status"));
        User user = this.userDAO.getUserByID(proposal.getLibraryUserId());
        request.setAttribute("requestedUser",user);
        this.proposalDAO.changeProposalStatus(status.getDescription(),proposalId);
        List<Proposal> proposals = this.proposalDAO.getProposalsOfUser(proposal.getLibraryUserId());
        request.setAttribute("proposals", proposals);
        Issuance issuance = issuanceDAO.getIssuanceByProposal(proposalId);
        if(status.getDescription() == "Выдана" && issuance == null) {
            this.issuanceDAO.addIssuance(proposalId);
        }
        forward(ConfigurationManager.getProperty("path.page.userrequests"));
    }
}
