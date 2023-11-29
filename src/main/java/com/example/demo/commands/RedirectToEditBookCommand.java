package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.utils.BookContainer;
import com.example.demo.utils.ConfigurationManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectToEditBookCommand extends Command {

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

    }

    @Override
    public void send() throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        System.out.println(id);
        request.setAttribute("bookDictionary", BookContainer.bookInfo.getAllBooks());
        forward(ConfigurationManager.getProperty("path.page.editbook"));
    }
}
