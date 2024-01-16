package com.example.demo.filters;

import com.example.demo.roles.RoleType;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.config.SecurityConfig;
import com.example.demo.utils.User;

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
            if (!SecurityConfig.checkRoleForCommand(commandInfo, RoleType.valueOf(user.getRoleName()))) {
                HttpSession session = request.getSession();
                session.setAttribute("accessStatus", ConfigurationManager.getProperty("message.accessStatus"));
                response.sendRedirect(contextPath);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

}
