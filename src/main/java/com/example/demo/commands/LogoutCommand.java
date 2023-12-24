package com.example.demo.commands;

import com.example.demo.utils.ConfigurationManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCommand extends Command {
    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        servletRequest.getSession().setAttribute("authorized", false);
    }

    @Override
    public void process() throws ServletException, IOException {

        forward(ConfigurationManager.getProperty("path.page.login"));
    }
}
