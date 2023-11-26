package com.example.demo.commands;

import com.example.demo.utils.BookRequestsContainer;
import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.utils.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class ViewRequestsCommand implements ActionCommand {
        @Override
        public String execute(HttpServletRequest request) {
            System.out.println("VIEWREQUESTSCOMMAND");
            request.setAttribute("requestDictionary", BookRequestsContainer.bookRequests);
            String page = ConfigurationManager.getProperty("path.page.requests");
            BookRequestsContainer.bookRequests.forEach((key, value) -> {
                System.out.println("Key: " + key + ", Value: " + value.getBookAuthor());
            });
            return page;
        }
    }

