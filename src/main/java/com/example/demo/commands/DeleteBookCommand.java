package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.BookDAO;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.utils.Book;
import com.example.demo.utils.ConfigurationManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DeleteBookCommand extends Command {

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
        int bookId = Integer.parseInt(request.getParameter("id"));
        List<Book> books = this.bookDAO.getAllBooks();
        request.setAttribute("books", books);
        try {
            this.bookDAO.deleteBook(bookId);
            forward(ConfigurationManager.getProperty("path.page.catalog"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            forward(ConfigurationManager.getProperty("path.page.error"));
        }
    }
}
