package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.BookDAO;
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
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUserById(id);

        if (user.getRole().getRoleName() == "ADMIN") {
            request.setAttribute("errorDeleteMessage", "У вас недостаточно прав для этого действия!");
            forward(ConfigurationManager.getProperty("path.page.userinfo"));
        }
        else {
            userDAO.deleteUser(user.getId());
            List<User> users = userDAO.getAllUsers();
            request.setAttribute("users", users);
            forward(ConfigurationManager.getProperty("path.page.usercatalog"));

        }
    }
}
