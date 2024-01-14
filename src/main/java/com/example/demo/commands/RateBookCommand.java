package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.BookDAO;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.UserVoteDAO;
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

public class RateBookCommand extends Command {
    private static DAOFactory daoFactory = null;

    public UserVoteDAO userVoteDAO;
    public BookDAO bookDAO;

    static {
        daoFactory = DAOFactory.getInstance(DBType.ORACLE);
    }

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        userVoteDAO = daoFactory.getUserVoteDAO();
        bookDAO = daoFactory.getBookDAO();
    }

    @Override
    public void send() throws ServletException, IOException, SQLException {
        User user = (User) request.getSession().getAttribute("user");
        String bookId = request.getParameter("id");
        String rate = request.getParameter("rate");
        Book book = this.bookDAO.getBookById(Integer.parseInt(bookId));
        float globalRating = book.getRating();
        int amountOfVoters;
        if(this.userVoteDAO.getUserVote(user.getId(),Integer.parseInt(bookId)) == null) {
            this.userVoteDAO.createUserVote(user.getId(),Integer.parseInt(bookId),Float.parseFloat(rate));
            globalRating = this.userVoteDAO.getAvarageRate(Integer.parseInt(bookId));
            //globalRating = ((globalRating * amountOfVoters) + Float.parseFloat(rate))/(amountOfVoters+1);
            this.bookDAO.updateBookRatingWithoutVoters(Integer.parseInt(bookId),globalRating);
            amountOfVoters = this.userVoteDAO.getAmountOfVotersByBookId(Integer.parseInt(bookId));
            this.bookDAO.setAmountOfVoters(Integer.parseInt(bookId),amountOfVoters);

        } else {
            this.userVoteDAO.updateUserVote(user.getId(),Integer.parseInt(bookId),Float.parseFloat(rate));
            globalRating = this.userVoteDAO.getAvarageRate(Integer.parseInt(bookId));
            //globalRating = ((globalRating * amountOfVoters-1) + Float.parseFloat(rate))/(amountOfVoters);
            this.bookDAO.updateBookRatingWithoutVoters(Integer.parseInt(bookId),globalRating);
            amountOfVoters = this.userVoteDAO.getAmountOfVotersByBookId(Integer.parseInt(bookId));
            this.bookDAO.setAmountOfVoters(Integer.parseInt(bookId),amountOfVoters);
        }
        List<Book> books = this.bookDAO.getAllBooks();
        request.setAttribute("books", books);
        forward(ConfigurationManager.getProperty("path.page.catalog"));
    }
}
