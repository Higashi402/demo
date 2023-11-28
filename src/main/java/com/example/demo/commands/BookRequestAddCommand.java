package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.utils.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class BookRequestAddCommand extends Command {

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

    }

    public void send() throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        if (!BookRequestsContainer.bookRequests.containsKey(id)) {
            try {
                BookRequestManager.addBookRequest(BookRequestsContainer.bookRequests, BookDictionary.createBookDictionaryWithInitialData(), id);
                request.setAttribute("resMessage",
                        MessageManager.getProperty("message.addingrequestsucces"));
                System.out.println("Книга добавлена");
                System.out.println(BookRequestsContainer.bookRequests.get(id));
                // Ваша логика добавления книги в заявки
            } catch (IllegalArgumentException e) {
                request.setAttribute("resMessage",
                        MessageManager.getProperty("message.existserror"));
            }
        } else {
            request.setAttribute("resMessage",
                    MessageManager.getProperty("message.existserror"));
            System.out.println("Книга уже есть");// Устанавливаем сообщение об ошибке, что книга с таким ID уже существует
        }

        BookDictionary iniBooks =  BookDictionary.createBookDictionaryWithInitialData();
        Map<Integer, BookEntry> bookDictionary = iniBooks.getAllBooks();
        request.setAttribute("bookDictionary", bookDictionary);

        System.out.println("Запрос выполнен");
        forward(ConfigurationManager.getProperty("path.page.bookinfo"));
    }
}
