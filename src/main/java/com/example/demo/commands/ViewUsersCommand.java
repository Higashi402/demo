package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.utils.*;
import com.example.demo.roles.RoleType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ViewUsersCommand extends Command  {
    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
    }

    @Override
    public void process() throws ServletException, IOException {
        System.out.println("VIEWUSERS");
        request.setAttribute("userDictionary", UserContainer.users);
        forward(ConfigurationManager.getProperty("path.page.usercatalog"));
    }

}