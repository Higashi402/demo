package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.db.DBType;
import com.example.demo.db.dao.BookDAO;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.ProposalDAO;
import com.example.demo.utils.ConfigurationManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RedirectToEditBookCommand extends Command {

    private static DAOFactory daoFactory = null;

    public BookDAO bookDAO;
    public ProposalDAO proposalDAO;

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
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.setAttribute("books", this.bookDAO.getAllBooks());
        forward(ConfigurationManager.getProperty("path.page.editbook"));
    }
}
