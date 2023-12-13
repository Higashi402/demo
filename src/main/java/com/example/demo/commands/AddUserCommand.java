package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.UserDAO;
import com.example.demo.roles.Role;
import com.example.demo.roles.RoleType;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AddUserCommand extends Command{
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
        String username = request.getParameter("username");
        String userFIO = request.getParameter("userFIO");
        String userPassword = request.getParameter("userPassword");
        String dateParameter = request.getParameter("userDOB"); // Получение параметра date в виде строки
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String role = request.getParameter("userRole");
        int roleTypeId = RoleType.valueOf(role).ordinal() + 1;
        List <User> users = userDAO.getAllUsers();

        if (username != null && userFIO != null && userPassword != null && userPassword != null && dateFormat != null
                && !username.isEmpty() && userFIO != null && !userPassword.isEmpty())  {
            try {
                boolean userExists = false;
                for (User user : users) {
                    if (user.getUsername().equals(username)) {
                        userExists = true;
                        break;
                    }
                }
                if (!userExists) {
                    this.userDAO.addUser(userFIO, dateParameter, username, userPassword, roleTypeId);
                    users = userDAO.getAllUsers();
                    request.setAttribute("users", users);
                    forward(ConfigurationManager.getProperty("path.page.usercatalog"));
                }
                else {
                    users = userDAO.getAllUsers();
                    request.setAttribute("users", users);
                    String message =ConfigurationManager.getProperty("message.userexistsmessage");
                    request.setAttribute("userexistsmessage", message);

                    forward(ConfigurationManager.getProperty("path.page.adduser"));
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
                forward(ConfigurationManager.getProperty("path.page.error"));
            }
        }
    }
}
