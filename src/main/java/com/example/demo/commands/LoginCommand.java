package com.example.demo.commands;

import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.UserDAO;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.sessionUtils.SessionManager;
import com.example.demo.utils.User;
import com.example.demo.roles.RoleType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand extends Command {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    private static final DAOFactory daoFactory = null;

    public UserDAO userDAO;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = daoFactory.getUserDAO();
    }


    @Override
    public void send() throws ServletException, IOException {
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        User user = this.userDAO.getUserByLogin(login);

        if (user != null && user.getPassword().equals(pass)) {
            request.getSession().setAttribute("user", user);
            User userOut = (User) request.getSession().getAttribute("user");
            System.out.println("В сессию зашел" + userOut.getUsername());
            request.getRequestDispatcher("jsp/menu.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher(ConfigurationManager.getProperty("path.page.login")).forward(request, response);
        }
    }
}
