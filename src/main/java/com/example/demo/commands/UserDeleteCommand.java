package com.example.demo.commands;

import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.RegularUser;
import com.example.demo.utils.User;
import com.example.demo.utils.UserContainer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteCommand extends Command {
    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
    }

    @Override
    public void send() throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = UserContainer.users.get(username);
        if (user instanceof RegularUser) {
            UserContainer.users.remove(username);
            request.setAttribute("userDictionary", UserContainer.users);
            forward(ConfigurationManager.getProperty("path.page.usercatalog"));
        }
        else {
            request.setAttribute("userDictionary", UserContainer.users);
            request.setAttribute("errorDeleteMessage", "У вас недостаточно прав для этого действия!");
            request.setAttribute("userRole", user.getRole());
            request.setAttribute("username", username);
            forward(ConfigurationManager.getProperty("path.page.userinfo"));
        }
    }
}
