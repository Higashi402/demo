package com.example.demo.commands;

import com.example.demo.utils.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class BlockUnblockUserCommand extends Command{

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

    }

    @Override
    public void send() throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = null;
        //if (user instanceof RegularUser) {
            //request.setAttribute("userDictionary", UserContainer.users);
            request.setAttribute("username", username);
            //boolean banFlag = ((RegularUser) user).getBlocked();
            //if (banFlag){
             //   ((RegularUser) user).setBlocked(false);
            //}
            //else {
            //    ((RegularUser) user).setBlocked(true);
            //}
            //forward(ConfigurationManager.getProperty("path.page.usercatalog"));
       // } else {
            request.setAttribute("errorMessage", "Заявки могут быть только у пользователей!");
            request.setAttribute("userRole", user.getRole());
            request.setAttribute("username", username);
            //request.setAttribute("userDictionary", UserContainer.users);
            forward(ConfigurationManager.getProperty("path.page.usercatalog"));

    }
}
