package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.ProposalDAO;
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

public class ViewNotificationsCommand extends Command{
    private static DAOFactory daoFactory = null;

    public ProposalDAO proposalDAO;

    static {
        daoFactory = DAOFactory.getInstance(DBType.ORACLE);
    }

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        proposalDAO = daoFactory.getProposalDAO();
    }

    @Override
    public void process() throws ServletException, IOException, SQLException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("user",user);
        List<Proposal> proposals = this.proposalDAO.getReadyToPickupProposalsOfUser(user.getId());
        request.setAttribute("proposals", proposals);
        forward(ConfigurationManager.getProperty("path.page.notifications"));
    }
}
