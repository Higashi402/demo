package com.example.demo.commands;

import com.example.demo.db.DBType;
import com.example.demo.db.dao.DAOFactory;
import com.example.demo.db.dao.IssuanceDAO;
import com.example.demo.roles.RoleType;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.Issuance;
import com.example.demo.utils.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class EditIssuanceDatesCommand extends Command{
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
        String issuanceId = this.request.getParameter("issuanceId");
        String issuanceDate = this.request.getParameter("issuancedate");
        String returningDate = this.request.getParameter("returningdate");
        System.out.println(issuanceId);
        this.issuanceDAO.updateIssuanceDates(issuanceDate,returningDate,issuanceId);
        List<Issuance> issuances = this.issuanceDAO.getAllIssuances();
        request.setAttribute("issuances", issuances);
        forward(ConfigurationManager.getProperty("path.page.issuances"));
    }
}
