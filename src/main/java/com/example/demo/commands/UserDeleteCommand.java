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

public class UserDeleteCommand extends Command {
    private static DAOFactory daoFactory = null;
    public UserDAO userDAO;

    public UserDeleteCommand() {
    }

    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        this.userDAO = daoFactory.getUserDAO();
    }

    public void send() throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(this.request.getParameter("id"));
        User user = this.userDAO.getUserByID(id);
        if (user.getRole().getRoleName() == "ADMIN") {
            this.request.setAttribute("errorDeleteMessage", "У вас недостаточно прав для этого действия!");
            this.forward(ConfigurationManager.getProperty("path.page.userinfo"));
        } else {
            this.userDAO.deleteUser(user.getId());
            List<User> users = this.userDAO.getAllUsers();
            this.request.setAttribute("users", users);
            this.forward(ConfigurationManager.getProperty("path.page.usercatalog"));
        }

    }

    static {
        daoFactory = DAOFactory.getInstance(DBType.ORACLE);
    }
}
