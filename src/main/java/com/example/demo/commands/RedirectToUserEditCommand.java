package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.UserDAO;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RedirectToUserEditCommand extends Command{
    private static DAOFactory daoFactory = null;

    public UserDAO userDAO;

    static {
        daoFactory = DAOFactory.getInstance(DBType.ORACLE);
    }

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        userDAO = daoFactory.getUserDAO();
    }

    @Override
    public void send() throws ServletException, IOException, SQLException {
       int userId =Integer.parseInt(request.getParameter("id"));
        List<User> users = this.userDAO.getAllUsers();
        User user = this.userDAO.getUserById(userId);
        request.setAttribute("requesteduser", user);
        request.setAttribute("users", users);
        forward(ConfigurationManager.getProperty("path.page.edituser"));
    }
}
