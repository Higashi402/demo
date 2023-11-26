package com.example.demo.utils;

import com.example.demo.utils.BookDictionary;
import com.example.demo.utils.BookRequest;

import java.util.HashMap;
import java.util.Map;

public class BookRequestsContainer {
    public static Map<Integer, BookRequest> bookRequests = new HashMap<>();
    private static final BookDictionary iniBooks = (BookDictionary) BookContainer.bookInfo;

}
