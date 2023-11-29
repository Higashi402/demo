package com.example.demo.commands;

import com.example.demo.utils.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class ViewUserRequests extends Command{
    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        System.out.println("Заявки пользователя инит");
    }
    @Override
    public void process() throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = UserContainer.users.get(username);
        if (user instanceof RegularUser) {
            RegularUser regularUser = (RegularUser) user;
            HashMap<Integer, BookRequest> userRequests = regularUser.getApplications();
            request.setAttribute("requestDictionary", userRequests);
            request.setAttribute("username", username);
            userRequests.forEach((key, value) -> {
                System.out.println(user.getUsername() + " " + key + ", Value: " + value.getRequestStatus());
            });
            forward(ConfigurationManager.getProperty("path.page.userrequests"));
        } else {
            request.setAttribute("errorMessage", "Заявки могут быть только у пользователей!");
            request.setAttribute("userRole", user.getRole());
            request.setAttribute("username", username);
            request.setAttribute("userDictionary", UserContainer.users);
            forward(ConfigurationManager.getProperty("path.page.userinfo"));
        }
    }
}
