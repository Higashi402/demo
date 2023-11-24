package com.example.demo;

import javax.servlet.http.HttpServletRequest;

public class CloseCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.user");
        return page;
    }
}
