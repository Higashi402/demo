package com.example.demo;

import javax.servlet.http.HttpServletRequest;

public class BookRequestDeleteCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        int removeId = Integer.parseInt(request.getParameter("removeId"));
        BookRequestManager.removeBookRequest(BookRequestsContainer.bookRequests, removeId);
        request.setAttribute("requestDictionary", BookRequestsContainer.bookRequests);
        String page = ConfigurationManager.getProperty("path.page.user");
        String result;
        return page;
    }
}
