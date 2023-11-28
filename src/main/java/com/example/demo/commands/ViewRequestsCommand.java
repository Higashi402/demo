package com.example.demo.commands;

import com.example.demo.utils.*;
import com.example.demo.CommandUtils.ActionCommand;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ViewRequestsCommand extends Command {
    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
    }

    @Override
    public void process() throws ServletException, IOException {
        System.out.println("VIEWREQUESTSCOMMAND");
        RegularUser user = (RegularUser) request.getSession().getAttribute("user");
        HashMap<Integer, BookRequest> userRequests = user.getApplications();
        request.setAttribute("requestDictionary", userRequests);
        userRequests.forEach((key, value) -> {
            System.out.println(user.getUsername() + " " + key + ", Value: " + value.getBookAuthor());
        });
        forward(ConfigurationManager.getProperty("path.page.requests"));
    }

}

