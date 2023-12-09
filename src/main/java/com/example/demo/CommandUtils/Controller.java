package com.example.demo.CommandUtils;

import com.example.demo.commands.EmptyCommand;
import com.example.demo.commands.Command;
import com.example.demo.utils.MessageManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Command command = getCommand(request);
        command.init(getServletContext(),request,response);
        try {
            command.process();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Command command = getCommand(request);
        command.init(getServletContext(),request,response);
        try {
            command.send();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Command getCommand(HttpServletRequest request) throws ServletException, IOException {
        Command current = new EmptyCommand();

        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }

        try {
            CommandEnum currentEnum =
                    CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
            System.out.println(action.toUpperCase());
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action
                    + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }


}