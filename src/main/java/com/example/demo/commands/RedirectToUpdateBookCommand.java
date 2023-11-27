package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.utils.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class RedirectToUpdateBookCommand implements ActionCommand {
    @Override

    public String execute(HttpServletRequest request) {
        String id = request.getParameter("bookId");
        System.out.println("Запрос есть" + id);
        request.setAttribute("id", id);
        String page =  ConfigurationManager.getProperty("path.page.updatebook");
        return page;
    }
}
