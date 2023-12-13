package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.ProposalDAO;
import com.example.demo.db.dao.UserDAO;
import com.example.demo.utils.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class ViewUserRequests extends Command{

    public ProposalDAO proposalDAO;
    public  UserDAO userDAO;
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
    public void process() throws ServletException, IOException, SQLException {
        System.out.println("Заявки для пользователея");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUserById(id);
        if (user != null) {
            List <User> users= userDAO.getAllUsers();
            request.setAttribute("requestedUser",user);
            List<Proposal> proposals = this.proposalDAO.getProposalsOfUser(user.getId());
            request.setAttribute("proposals", proposals);
        }
        forward(ConfigurationManager.getProperty("path.page.userrequests"));
    }
}
