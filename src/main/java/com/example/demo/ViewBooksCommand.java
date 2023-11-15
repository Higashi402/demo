package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;



public class ViewBooksCommand implements ActionCommand {

        @Override
        public String execute(HttpServletRequest request) {
            System.out.println("123123");

            BookDictionary iniBooks =  BookDictionary.createBookDictionaryWithInitialData();
            Map<Integer, BookEntry> bookDictionary = iniBooks.getAllBooks();
            request.setAttribute("bookDictionary", bookDictionary);
            String page = ConfigurationManager.getProperty("path.page.user");
            return page; // Замените на актуальный путь
        }
}

