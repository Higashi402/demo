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
            this.proposalDAO.addProposal(user.getId(),Integer.parseInt(bookId));
        }
        //proposalDAO.addProposal();

        // Проверка наличия пользователя и его роли
        //if (user != null && user.getRole() == RoleType.USER) {
            //int id = Integer.parseInt(request.getParameter("id"));
            //RegularUser regularUser = (RegularUser) user;
            //if (!regularUser.getApplications().containsKey(id)) {
                //try {
                    // Добавление заявки пользователю в его словарь
                    //UserContainer.addBookRequestToUser(regularUser, id, new BookRequest(BookContainer.bookInfo.getBookById(id), RequestStatus.INPROCESSING));
                    //request.getSession().setAttribute("user", regularUser);// здесь должен быть ваш объект BookRequest
                    //request.setAttribute("resMessage", MessageManager.getProperty("message.addingrequestsucces"));
                   // System.out.println("Заявка добавлена для пользователя: " + regularUser.getUsername());
                //} catch (Exception e) {
                    //request.setAttribute("resMessage", MessageManager.getProperty("message.existserror"));
                //}
            //} else {
                //request.setAttribute("resMessage", MessageManager.getProperty("message.existserror"));
                //System.out.println("Заявка уже существует для пользователя: " + regularUser.getUsername());
            //}
       // } else {
            //request.setAttribute("resMessage", MessageManager.getProperty("message.permissionerror"));
            //System.out.println("Недостаточно прав для добавления заявки");
        //}

        //request.setAttribute("bookDictionary", BookContainer.bookInfo.getAllBooks());

        System.out.println("Запрос выполнен");
        forward(ConfigurationManager.getProperty("path.page.catalog"));
    }
}
