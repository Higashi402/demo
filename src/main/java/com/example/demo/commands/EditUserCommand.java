package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.UserDAO;
import com.example.demo.roles.RoleType;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.User;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditUserCommand extends Command {
    private static DAOFactory daoFactory = null;
    public UserDAO userDAO;

    public EditUserCommand() {
    }

    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        this.userDAO = daoFactory.getUserDAO();
    }

    public void send() throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(this.request.getParameter("id"));
        User user = this.userDAO.getUserByID(id);
        System.out.println(user.getUserFIO());
        String username = this.request.getParameter("username");
        String userFIO = this.request.getParameter("userFIO");
        String userPassword = this.request.getParameter("userPassword");
        String dateParameter = this.request.getParameter("userDOB");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String role = this.request.getParameter("userRole");
        int roleTypeId = RoleType.valueOf(role).ordinal() + 1;
        if (username != null && userFIO != null && userPassword != null && userPassword != null && dateFormat != null && !username.isEmpty() && userFIO != null && !userPassword.isEmpty()) {
            try {
                this.userDAO.updateUser(id, userFIO, dateParameter, username, userPassword, roleTypeId);
                System.out.println(user.getUserFIO());
                List<User> users;
                users = this.userDAO.getAllUsers();
                this.request.setAttribute("users", users);
                this.forward(ConfigurationManager.getProperty("path.page.usercatalog"));
            } catch (NumberFormatException var11) {
                var11.printStackTrace();
                this.forward(ConfigurationManager.getProperty("path.page.error"));
            }
        }

    }

    static {
        daoFactory = DAOFactory.getInstance(DBType.ORACLE);
    }
}
