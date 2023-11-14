package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDictionary {
    private Map<Integer, BookEntry > bookInfo = new HashMap<>();

    // Конструктор класса
    public static BookDictionary createBookDictionaryWithInitialData() {
        BookDictionary bookDictionary = new BookDictionary();
        bookDictionary.addBook(1, "Мастер и маргарита", "М Булгаков", 10, 3);
        bookDictionary.addBook(2, "Война и мир", "Л Толстой", 3, 5);
        bookDictionary.addBook(3, "О дивный новый мир", "О Хаксли", 3, 5);
        bookDictionary.addBook(4, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(5, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(6, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(7, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(8, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(9, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(10, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(11, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(12, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(13, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(14, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(15, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(16, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(17, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(18, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(19, "gwehwe", "А Пруцков", 3, 5);
        bookDictionary.addBook(20, "gwehwe", "А Пруцков", 3, 5);

        return bookDictionary;
    }
    // Метод для добавления книги в словарь
    public void addBook(int id, String title, String author, int quantity ,double rating) {
        BookEntry bookData = new BookEntry(title, author, quantity, rating);
        bookInfo.put(id, bookData);
    }

    // Метод для удаления книги по ID
    public void removeBook(int id) {
        bookInfo.remove(id);
    }

    public Map<Integer, BookEntry> getAllBooks() {
        return bookInfo;
    }

}




