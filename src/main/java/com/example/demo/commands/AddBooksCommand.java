package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.db.DBType;
import com.example.demo.db.dao.BookDAO;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.utils.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AddBooksCommand extends Command {

    private static DAOFactory daoFactory = null;

    public BookDAO bookDAO;

    static {
        daoFactory = DAOFactory.getInstance(DBType.ORACLE);
    }

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        bookDAO = daoFactory.getBookDAO();
    }

    @Override
    public void send() throws ServletException, IOException, SQLException {
        String title = request.getParameter("titleValue");
        String author = request.getParameter("authorValue");
        String amount = request.getParameter("amountValue");
        List<Book> books = this.bookDAO.getAllBooks();
        request.setAttribute("books", books);
        if (title != null && !title.isEmpty() && author != null && !author.isEmpty() && amount != null && !amount.isEmpty()) {
            try {
                this.bookDAO.addBook(title,title,Integer.parseInt(amount));
                forward(ConfigurationManager.getProperty("path.page.catalog"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                forward(ConfigurationManager.getProperty("path.page.error"));
            }
        }
    }

    //private int generateNewBookId(BookDictionary bookDictionary) {
        //return bookDictionary.getDictionarySize() + 1;
   // }
}

