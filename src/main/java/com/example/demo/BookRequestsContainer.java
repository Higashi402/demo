package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class BookRequestsContainer {
    public static Map<Integer, BookRequest> bookRequests = new HashMap<>();
    private static final BookDictionary iniBooks = BookDictionary.createBookDictionaryWithInitialData();

}
