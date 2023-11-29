package com.example.demo.commands;

import com.example.demo.utils.ConfigurationManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewUsersRequestInformationCommand extends Command{
    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
    }

    @Override
    public void send() throws ServletException, IOException {
        System.out.println("Request info command" + request.getParameter("username"));
        request.setAttribute("username", request.getParameter("username"));
        request.setAttribute("requestId", request.getParameter("id"));
        request.setAttribute("requestTitle", request.getParameter("title"));
        request.setAttribute("requestAuthor", request.getParameter("author"));
        request.setAttribute("requestStatus", request.getParameter("status"));


        forward(ConfigurationManager.getProperty("path.page.requsetinfo"));
    }
}
