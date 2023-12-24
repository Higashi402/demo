package com.example.demo.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BlockFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String contextPath = request.getContextPath();
        String pathInfo = request.getQueryString();
        User user = (User) request.getSession().getAttribute("user");
        if(user != null && user.getBlocked() == 1 )
        {
            if (pathInfo != null) {
                HttpSession session = request.getSession();
                session.setAttribute("blockStatus", ConfigurationManager.getProperty("message.blockerror"));
                response.sendRedirect(contextPath);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

}
