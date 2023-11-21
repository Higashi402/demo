package com.example.demo;

import javax.servlet.http.HttpServletRequest;

public class BookRequestsViewCommand implements ActionCommand {
        @Override
        public String execute(HttpServletRequest request) {
            request.setAttribute("requestDictionary", BookRequestsContainer.bookRequests);
            String page = ConfigurationManager.getProperty("path.page.user");
            BookRequestsContainer.bookRequests.forEach((key, value) -> {
                System.out.println("Key: " + key + ", Value: " + value.getBookAuthor());
            });
            return page;
        }
    }

