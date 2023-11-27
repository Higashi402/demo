package com.example.demo.commands;

import com.example.demo.utils.ConfigurationManager;
import com.example.demo.sessionUtils.SessionManager;
import com.example.demo.utils.UserDictionary;
import com.example.demo.roles.RoleType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand extends Command {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

    }


    @Override
    public void send() throws ServletException, IOException {
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        RoleType userRole = UserDictionary.getUserRole(login);
        String storedPassword = UserDictionary.getUserPassword(login);

        if (storedPassword != null && storedPassword.equals(pass)) {
            SessionManager.setUserRole(request, userRole);
            request.setAttribute("user", login);
            redirect("jsp/menu.jsp");
        } else {
            forward(ConfigurationManager.getProperty("path.page.login"));
        }
    }
}
