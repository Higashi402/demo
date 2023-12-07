package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.utils.ConfigurationManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookRequestDeleteCommand extends Command {

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
    }

    @Override
    public void send() throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        //RegularUser user = (RegularUser) UserContainer.users.get(request.getParameter("username"));
        //user.getApplications().remove(id);
       // request.setAttribute("requestDictionary", user.getApplications());
        request.setAttribute("username", request.getParameter("username"));
        forward(ConfigurationManager.getProperty("path.page.userrequests"));
    }
}
