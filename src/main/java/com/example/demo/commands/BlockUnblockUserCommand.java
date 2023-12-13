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
import java.util.HashMap;
import java.util.List;

public class BlockUnblockUserCommand extends Command{

    public UserDAO userDAO;
    private static DAOFactory daoFactory = null;

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
        int id = Integer.parseInt(this.request.getParameter("id"));
        User user = this.userDAO.getUserByID(id);
        List<User> users = userDAO.getAllUsers();
        if (user.getRole().getRoleName() != "USER") {
            request.setAttribute("users", users);
            request.setAttribute("requesteduser", user);
            this.request.setAttribute("errorDeleteMessage", "У вас недостаточно прав для этого действия!");
        } else {
                if(user.getBlocked() == 0) {
                    this.userDAO.blockUser(user.getId());
                } else {
                    this.userDAO.unBlockUser(user.getId());
                }
            users = userDAO.getAllUsers();
            user = this.userDAO.getUserByID(id);
            request.setAttribute("users", users);
            request.setAttribute("requesteduser", user);
            forward(ConfigurationManager.getProperty("path.page.userinfo"));
        }
        forward(ConfigurationManager.getProperty("path.page.userinfo"));
    }
}
