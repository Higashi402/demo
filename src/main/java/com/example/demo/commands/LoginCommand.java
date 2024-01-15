package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.UserDAO;
import com.example.demo.utils.BlockFilter;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginCommand extends Command  {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    private static DAOFactory daoFactory = null;

    public UserDAO userDAO;

    static {
        daoFactory = DAOFactory.getInstance(DBType.ORACLE);
    }

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

        userDAO = daoFactory.getUserDAO();
    }


    @Override
    public void send() throws ServletException, IOException, SQLException {
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        User user = this.userDAO.getUserByLogin(login);
        if (user != null && user.getPassword().equals(pass)) {
            HttpSession session = request.getSession();
            if (user.getBlocked() == 1) {
                session.setAttribute("blockStatus", ConfigurationManager.getProperty("message.blockerror"));
                request.getRequestDispatcher(ConfigurationManager.getProperty("path.page.login")).forward(request, response);
                return;
            }
            session.setAttribute("user", user);
            session.setAttribute("authorized", true);
            //session.setAttribute("accessStatus", "");
            User userOut = (User) session.getAttribute("user");
            System.out.println(userOut.getRoleName());
            System.out.println(userOut.getId());
            System.out.println("В сессию зашел " + userOut.getUsername());
            request.getRequestDispatcher("jsp/menu.jsp").forward(request, response);
        } else {
            request.setAttribute("errormsg", ConfigurationManager.getProperty("message.loginerror"));
            request.getRequestDispatcher(ConfigurationManager.getProperty("path.page.login")).forward(request, response);
        }
    }
}
