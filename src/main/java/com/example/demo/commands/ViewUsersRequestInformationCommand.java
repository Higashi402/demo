package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.ProposalDAO;
import com.example.demo.db.dao.UserDAO;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.Proposal;
import com.example.demo.utils.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ViewUsersRequestInformationCommand extends Command{

    public ProposalDAO proposalDAO;
    public UserDAO userDAO;
    private static DAOFactory daoFactory = null;

    static {
        daoFactory = DAOFactory.getInstance(DBType.ORACLE);
    }

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        proposalDAO = daoFactory.getProposalDAO();
        userDAO = daoFactory.getUserDAO();
    }

    @Override
    public void send() throws ServletException, IOException, SQLException {
        Proposal proposal = this.proposalDAO.getProposalById(Integer.parseInt(request.getParameter("id")));
        User user = userDAO.getUserByID(proposal.getLibraryUserId());
        request.setAttribute("username", user.getUserFIO());
        request.setAttribute("requestId", proposal.getId());
        request.setAttribute("requestTitle", proposal.getBookTitle());
        request.setAttribute("requestAuthor", proposal.getAuthor());
        request.setAttribute("requestStatus", proposal.getProposalStatus());
        forward(ConfigurationManager.getProperty("path.page.requsetinfo"));
    }
}
