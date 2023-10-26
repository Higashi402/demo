package com.example.demo;

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

        UserDictionary userDictionary = new UserDictionary();
        RoleType userRole = userDictionary.getUserRole(login);
        String storedPassword = userDictionary.getUserPassword(login);

        if (storedPassword != null && storedPassword.equals(pass)) {
            // Проверка роли пользователя и установка соответствующей страницы
            if (userRole == RoleType.USER) {
                page = ConfigurationManager.getProperty("path.page.user");
            } else if (userRole == RoleType.MODERATOR) {
                page = ConfigurationManager.getProperty("path.page.moderator");
            } else if (userRole == RoleType.ADMIN) {
                page = ConfigurationManager.getProperty("path.page.admin");
            }

            request.setAttribute("user", login);
        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
