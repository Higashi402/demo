package com.example.demo.utils;

import com.example.demo.utils.BookDictionary;
import com.example.demo.utils.BookEntry;
import com.example.demo.utils.BookRequest;

import java.util.HashMap;
import java.util.Map;

public class BookRequestManager {

    private static Map<Integer, BookRequest> bookRequests = new HashMap<>();

    private BookRequestManager() {

    }

    public static void addBookRequest(Map<Integer, BookRequest> bookRequests, BookDictionary bookDictionary, int bookId) {
        BookEntry bookEntry = bookDictionary.getBookById(bookId);
        if (bookEntry != null) {
            bookRequests.put(bookId, new BookRequest(bookEntry.getTitle(), bookEntry.getAuthor()));
        }
    }

    public static void removeBookRequest(Map<Integer, BookRequest> bookRequests, int bookId) {
        bookRequests.remove(bookId);
    }

    public static Map<Integer, BookRequest> getAllBookRequests(Map<Integer, BookRequest> bookRequests) {
        return new HashMap<>(bookRequests);
    }
}