package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;

import javax.servlet.http.HttpServletRequest;

public class EditBookCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("id");
        String title = request.getParameter("titleValue");
        String author = request.getParameter("authorValue");
        String amount = request.getParameter("amountValue");
        String rating = request.getParameter("rating");
        return null;
    }
}
