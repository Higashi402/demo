package com.example.demo;

import com.example.demo.roles.RoleType;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ViewBooksCommand implements ActionCommand {

        @Override
        public String execute(HttpServletRequest request) {
            BookDictionary iniBooks =  BookDictionary.createBookDictionaryWithInitialData();
            Map<Integer, BookEntry> bookDictionary = iniBooks.getAllBooks();
            request.setAttribute("bookDictionary", bookDictionary);
            String page = ConfigurationManager.getProperty("path.page.user");
            return page; // Замените на актуальный путь
        }
}

