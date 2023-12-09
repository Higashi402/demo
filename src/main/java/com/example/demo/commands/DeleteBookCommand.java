package com.example.demo.commands;

import com.example.demo.utils.ConfigurationManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBookCommand extends Command {

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
    }

    @Override
    public void send() throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        try {
            //BookContainer.bookInfo.removeBook(bookId);
            //Map<Integer, BookEntry> bookDictionary =  BookContainer.bookInfo.getAllBooks();
            //request.setAttribute("bookDictionary", bookDictionary);
            forward(ConfigurationManager.getProperty("path.page.catalog"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            forward(ConfigurationManager.getProperty("path.page.error"));
        }
    }
}
