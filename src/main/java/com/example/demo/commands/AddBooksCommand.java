package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.utils.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBooksCommand extends Command {

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

    }

    @Override
    public void send() throws ServletException, IOException {
        String title = request.getParameter("titleValue");
        String author = request.getParameter("authorValue");
        String amount = request.getParameter("amountValue");
        if (title != null && !title.isEmpty() && author != null && !author.isEmpty() && amount != null && !amount.isEmpty()) {
            try {
                int intamount = Integer.parseInt(amount);
                int newBookId = generateNewBookId(BookContainer.bookInfo);
                BookContainer.bookInfo.addBook(newBookId, title, author, intamount, 0);
                request.setAttribute("bookDictionary", BookContainer.bookInfo.getAllBooks());
                forward(ConfigurationManager.getProperty("path.page.catalog"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                forward(ConfigurationManager.getProperty("path.page.error"));
            }
        }
    }

    private int generateNewBookId(BookDictionary bookDictionary) {
        return bookDictionary.getDictionarySize() + 1;
    }
}

