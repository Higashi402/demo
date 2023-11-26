package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.MessageManager;
import com.example.demo.sessionUtils.SessionManager;
import com.example.demo.utils.UserDictionary;
import com.example.demo.roles.RoleType;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";



    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        RoleType userRole = UserDictionary.getUserRole(login);
        String storedPassword = UserDictionary.getUserPassword(login);

        if (storedPassword != null && storedPassword.equals(pass)) {
            SessionManager.setUserRole(request, userRole);
            page = ConfigurationManager.getProperty("path.page.menu");
            request.setAttribute("user", login);
        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
