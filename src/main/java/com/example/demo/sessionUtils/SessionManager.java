package com.example.demo.sessionUtils;

import com.example.demo.roles.RoleType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionManager {
    public static void setUserRole(HttpServletRequest request, RoleType userRole) {
        HttpSession session = request.getSession();
        session.setAttribute("userRole", userRole);
    }

    // Получаем роль пользователя из сессии
    public static String getUserRole(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (String) session.getAttribute("userRole");
    }

    // Очищаем информацию о роли пользователя из сессии
    public static void clearUserRole(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("userRole");
    }
}
