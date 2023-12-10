package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.BookDAO;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.UserDAO;
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

public class ViewBooksCommand extends Command {

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
    public void process() throws ServletException, IOException, SQLException {
        List<Book> books = this.bookDAO.getAllBooks();
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getRoleName());
        request.setAttribute("user",user);
        request.setAttribute("books", books);
        forward(ConfigurationManager.getProperty("path.page.catalog"));
    }
}
