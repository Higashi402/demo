package com.example.demo;

import javax.servlet.http.HttpServletRequest;

public class UserCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        String action = request.getParameter("action");
        request.setAttribute("action", action);
        String page = ConfigurationManager.getProperty("path.page.user");
        return page; // Замените на актуальный путь
    }
}
