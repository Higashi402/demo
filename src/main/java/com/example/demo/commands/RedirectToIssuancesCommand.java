package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.IssuanceDAO;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.Issuance;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RedirectToIssuancesCommand extends Command{

    private static DAOFactory daoFactory = null;

    public IssuanceDAO issuanceDAO;

    static {
        daoFactory = DAOFactory.getInstance(DBType.ORACLE);
    }

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        issuanceDAO = daoFactory.getIssuanceDAO();
    }

    @Override
    public void process() throws ServletException, IOException, SQLException {
        List<Issuance> issuances = this.issuanceDAO.getAllIssuances();
        request.setAttribute("issuances", issuances);
        forward(ConfigurationManager.getProperty("path.page.issuances"));
    }
}
