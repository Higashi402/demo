package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.utils.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class CloseCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.user");
        return page;
    }
}
