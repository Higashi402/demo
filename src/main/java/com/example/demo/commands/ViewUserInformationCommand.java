package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.UserDAO;
import com.example.demo.utils.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ViewUserInformationCommand extends Command {

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
    public void process() throws ServletException, IOException, SQLException {
        String username = request.getParameter("name");
        if (username != null) {
            List <User> users= userDAO.getAllUsers();
            User user = userDAO.getUserByLogin(username);
            request.setAttribute("requesteduser", user);
            request.setAttribute("users", users);
        }
        forward(ConfigurationManager.getProperty("path.page.userinfo"));
    }
}
