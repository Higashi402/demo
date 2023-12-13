package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.BookDAO;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.ProposalDAO;
import com.example.demo.utils.Book;
import com.example.demo.utils.ConfigurationManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditBookCommand extends Command {

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
    public void send() throws ServletException, IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("titleValue");
        String author = request.getParameter("authorValue");
        String amount = request.getParameter("amountValue");
        String rating = request.getParameter("rating");
        List<Book> books = new ArrayList<>();
        if (title != null && !title.isEmpty() && author != null && !author.isEmpty() && amount != null &&
                !amount.isEmpty() && rating != null && !rating.isEmpty() && id != null && !id.isEmpty()) {
            try {
                // Парсим значение рейтинга в число
                int intamount = Integer.parseInt(amount);
                int intid = Integer.parseInt(id);
                double doublerating = Double.parseDouble(rating);
                this.bookDAO.updateBook(intid,title, author, intamount);
                books = this.bookDAO.getAllBooks();
                request.setAttribute("books", books);
                forward(ConfigurationManager.getProperty("path.page.catalog"));
            } catch (NumberFormatException e) {
                forward(ConfigurationManager.getProperty("path.page.catalog"));
                // Обработка ошибки, если значение рейтинга не удалось преобразовать в число
                e.printStackTrace(); // или другая логика обработки ошибки
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
