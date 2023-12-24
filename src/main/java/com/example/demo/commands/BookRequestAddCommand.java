package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.db.DBType;
import com.example.demo.db.dao.BookDAO;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.ProposalDAO;
import com.example.demo.roles.RoleType;
import com.example.demo.utils.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BookRequestAddCommand extends Command {

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
        proposalDAO = daoFactory.getProposalDAO();
    }

    public void send() throws ServletException, IOException, SQLException {
        User user = (User) request.getSession().getAttribute("user");
        String pathPage = null;
        List<Book> books = this.bookDAO.getAllBooks();
        System.out.println(user.getRoleName());
        request.setAttribute("user",user);
        request.setAttribute("books", books);
        String bookId = request.getParameter("id");
        System.out.println(bookId);
        List<Proposal> proposals = this.proposalDAO.getProposalsOfUser(user.getId());

        boolean cancel = false;
        for(int i = 0;i<proposals.size();i++) {
            if(proposals.get(i).getBookId() == Integer.parseInt(bookId)) {
                cancel = true;
                break;
            }
        }
        if(!cancel) {
            if (this.bookDAO.getBookById(Integer.parseInt(bookId)).getAmount() != 0){
                this.bookDAO.decreaseBookAmountById(Integer.parseInt(bookId));
                this.proposalDAO.addProposal(user.getId(),Integer.parseInt(bookId));
                pathPage = ConfigurationManager.getProperty("path.page.catalog");
            }
            else {
                request.setAttribute("resMessage", ConfigurationManager.getProperty("message.notavailablemessage"));
                pathPage = ConfigurationManager.getProperty("path.page.bookinfo");
            }

        } else
        {
            request.setAttribute("resMessage", ConfigurationManager.getProperty("message.existserror"));
            pathPage = ConfigurationManager.getProperty("path.page.bookinfo");
        }
        forward(pathPage);
    }
}
