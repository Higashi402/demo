package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class BookRequestManager {

    private static Map<Integer, BookRequest> bookRequests = new HashMap<>();

    private BookRequestManager() {
        // Конструктор оставлен пустым
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



    // Другие методы для работы с заявками...
}