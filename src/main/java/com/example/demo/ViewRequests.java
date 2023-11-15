package com.example.demo;

import javax.servlet.http.HttpServletRequest;

public class ViewRequests implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("4124123");
        request.setAttribute("requestDictionary", BookRequestCommand.bookRequests);
        String page = ConfigurationManager.getProperty("path.page.user");
        String result;
    /*    result = BookRequestCommand.bookRequests.;*/
   /*     System.out.println(result);*/
        return page;
    }
}