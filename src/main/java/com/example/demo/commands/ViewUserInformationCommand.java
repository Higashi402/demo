package com.example.demo.commands;

import com.example.demo.utils.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ViewUserInformationCommand extends Command {
    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
    }

    @Override
    public void send() throws ServletException, IOException {
        System.out.println("User info command" + request.getParameter("name"));
        User user = null;
        //if (user instanceof RegularUser) {
           //boolean banFlag = ((RegularUser) user).getBlocked();
            //request.setAttribute("userBlock", banFlag);
        //}
        request.setAttribute("username", request.getParameter("name"));
        request.setAttribute("userRole", request.getParameter("role"));
        //request.setAttribute("userDictionary", UserContainer.users);
        forward(ConfigurationManager.getProperty("path.page.userinfo"));
    }
}
