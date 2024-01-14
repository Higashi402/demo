package com.example.demo.utils;

import com.example.demo.roles.RoleType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String contextPath = request.getContextPath();
        String commandInfo = request.getParameter("command");
        User user = (User) request.getSession().getAttribute("user");
        if(user != null && commandInfo != null)
        {
            if (!SecurityWrapper.checkRoleForCommand(commandInfo, RoleType.valueOf(user.getRoleName()))) {
                HttpSession session = request.getSession();
                session.setAttribute("blockStatus", ConfigurationManager.getProperty("message.blockerror"));
                response.sendRedirect(contextPath);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

}
