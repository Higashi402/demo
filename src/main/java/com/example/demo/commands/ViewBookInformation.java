package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.BookDAO;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.utils.Book;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ViewBookInformation extends Command{

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
        String bookId = request.getParameter("id");
        String bookTitle = request.getParameter("title");
        String bookAuthor = request.getParameter("author");
        String bookRating = request.getParameter("rating");

        request.setAttribute("bookId", bookId);
        request.setAttribute("bookTitle", bookTitle);
        request.setAttribute("bookAuthor", bookAuthor);
        request.setAttribute("bookRating", bookRating);

        List<Book> books = this.bookDAO.getAllBooks();
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getRoleName());
        request.setAttribute("user",user);
        request.setAttribute("books", books);

        forward(ConfigurationManager.getProperty("path.page.bookinfo"));
    }
}
