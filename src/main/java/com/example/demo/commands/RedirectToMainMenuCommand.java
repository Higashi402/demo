package com.example.demo.commands;

import com.example.demo.utils.BookDictionary;
import com.example.demo.utils.BookEntry;
import com.example.demo.utils.ConfigurationManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class RedirectToMainMenuCommand extends Command{

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

    }

    @Override
    public void send() throws ServletException, IOException {
        redirect("jsp/menu.jsp");
    }
}
