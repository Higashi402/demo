package com.example.demo.commands;

import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.RegularUser;
import com.example.demo.utils.RequestStatus;
import com.example.demo.utils.UserContainer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateRequestStatusCommand extends Command{
    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
    }

    @Override
    public void send() throws ServletException, IOException {
        System.out.println("Статус и зменен на " + request.getParameter("status"));
        RequestStatus status = RequestStatus.valueOf(request.getParameter("status"));
        Integer id = Integer.valueOf(request.getParameter("id"));
        RegularUser user = (RegularUser) UserContainer.users.get(request.getParameter("username"));
        user.getApplications().get(id).setRequestStatus(status);
        request.setAttribute("requestDictionary", user.getApplications());
        request.setAttribute("username", request.getParameter("username"));
        forward(ConfigurationManager.getProperty("path.page.userrequests"));
    }
}
