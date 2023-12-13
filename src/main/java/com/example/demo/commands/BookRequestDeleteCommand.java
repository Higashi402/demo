package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.db.DBType;
import com.example.demo.db.dao.BookDAO;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.ProposalDAO;
import com.example.demo.db.dao.UserDAO;
import com.example.demo.utils.Book;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.Proposal;
import com.example.demo.utils.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BookRequestDeleteCommand extends Command {

    private static DAOFactory daoFactory = null;

    public BookDAO bookDAO;
    public ProposalDAO proposalDAO;
    public UserDAO userDAO;

    static {
        daoFactory = DAOFactory.getInstance(DBType.ORACLE);
    }

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        bookDAO = daoFactory.getBookDAO();
        proposalDAO = daoFactory.getProposalDAO();
        userDAO = daoFactory.getUserDAO();
    }

    @Override
    public void send() throws ServletException, IOException, SQLException {
        int proposalId = Integer.parseInt(request.getParameter("id"));
        Proposal proposal = this.proposalDAO.getProposalById(proposalId);
        User user = this.userDAO.getUserByID(proposal.getLibraryUserId());
        request.setAttribute("requestedUser",user);

        this.proposalDAO.deleteProposalById(proposalId);
        List<Proposal> proposals = this.proposalDAO.getProposalsOfUser(proposal.getLibraryUserId());
        request.setAttribute("proposals", proposals);
        forward(ConfigurationManager.getProperty("path.page.userrequests"));
    }
}
