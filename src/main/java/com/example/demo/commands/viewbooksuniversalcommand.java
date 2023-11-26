package com.example.demo.commands;

import com.example.demo.utils.BookContainer;
import com.example.demo.utils.BookDictionary;
import com.example.demo.utils.BookEntry;
import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.utils.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class viewbooksuniversalcommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("123123");
        BookDictionary iniBooks =  BookContainer.bookInfo;
        Map<Integer, BookEntry> bookDictionary = iniBooks.getAllBooks();
        request.setAttribute("bookDictionary", bookDictionary);
        String page = ConfigurationManager.getProperty("path.page.catalog");
        return page; // Замените на актуальный путь
    }
}
