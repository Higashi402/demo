package com.example.demo;

import com.example.demo.roles.RoleType;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ViewUsersCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        Map<String, RoleType> userDictionary = UserDictionary.getUsers();
        request.setAttribute("userDictionary", userDictionary);
        String page = ConfigurationManager.getProperty("path.page.admin");
        for (Map.Entry<String, RoleType> entry : userDictionary.entrySet()) {
            System.out.println("User: " + entry.getKey() + ", Role: " + entry.getValue());
        }
        return page; // Замените на актуальный путь
    }
}