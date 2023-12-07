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

public class ViewBookInformation extends Command{

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
    }

    @Override
    public void send() throws ServletException, IOException {
        String bookId = request.getParameter("id");
        String bookTitle = request.getParameter("title");
        String bookAuthor = request.getParameter("author");
        String bookRating = request.getParameter("rating");
        System.out.println("Есть запрос" + bookId + bookTitle + bookAuthor + bookRating);
        // Устанавливаем атрибуты для использования в JSP
        request.setAttribute("bookId", bookId);
        request.setAttribute("bookTitle", bookTitle);
        request.setAttribute("bookAuthor", bookAuthor);
        request.setAttribute("bookRating", bookRating);

        //request.setAttribute("bookDictionary", BookContainer.bookInfo.getAllBooks());

        // Перенаправляем на страницу с информацией о книге
        forward(ConfigurationManager.getProperty("path.page.bookinfo"));
    }
}
