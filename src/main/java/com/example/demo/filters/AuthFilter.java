package com.example.demo.filters;

import com.example.demo.commands.LoginCommand;
import com.example.demo.utils.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String contextPath = request.getContextPath();
        String patnInfo = request.getQueryString();
        Boolean isAuthorized = (Boolean) request.getSession().getAttribute("authorized");
        User user = (User) request.getSession().getAttribute("user");
        if((isAuthorized != null && !isAuthorized) || user == null)
        {
            if (patnInfo != null) {
                response.sendRedirect(contextPath);
                return;
            }
        }
            filterChain.doFilter(request, response);
    }
}