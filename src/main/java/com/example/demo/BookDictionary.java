package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDictionary {
    private Map<Integer, BookEntry > bookInfo = new HashMap<>();

    public static BookDictionary createBookDictionaryWithInitialData() {
        BookDictionary bookDictionary = new BookDictionary();
        bookDictionary.addBook(1, "Мастер и маргарита", "М. Булгаков", 10, 3);
        bookDictionary.addBook(2, "Война и мир", "Л. Толстой", 3, 5);
        bookDictionary.addBook(3, "О дивный новый мир", "О. Хаксли", 3, 5);
        bookDictionary.addBook(4, "Гарри Поттер и узник Азкабана", "Д. Роулинг", 3, 5);
        bookDictionary.addBook(5, "Зелёная миля", "С. Кинг", 3, 5);
        bookDictionary.addBook(6, "Унесённые ветром", "М. Митчелл", 3, 5);
        bookDictionary.addBook(7, "Свита короля", "Н. Сакавич", 3, 5);
        bookDictionary.addBook(8, "Благословление небожителей", "М. Тунсю", 3, 5);
        bookDictionary.addBook(9, "Прислуга", "К. Стокетт", 3, 5);
        bookDictionary.addBook(10, "Граф Монте-Кристо", "А. Дюма", 3, 5);
        bookDictionary.addBook(11, "Буря мечей", "Д. Мартин", 3, 5);
        bookDictionary.addBook(12, "В списках не значился", "Б. Васильев", 3, 5);
        bookDictionary.addBook(14, "В списках не значился", "Б. Васильев", 3, 5);
        bookDictionary.addBook(15, "В списках не значился", "Б. Васильев", 3, 5);
        bookDictionary.addBook(16, "В списках не значился", "Б. Васильев", 3, 5);
        bookDictionary.addBook(17, "В списках не значился", "Б. Васильев", 3, 5);

        return bookDictionary;
    }

    public void addBook(int id, String title, String author, int amount ,double rating) {
        BookEntry bookData = new BookEntry(title, author, amount, rating);
        bookInfo.put(id, bookData);
    }

    public void removeBook(int id) {
        bookInfo.remove(id);
    }

    public Map<Integer, BookEntry> getAllBooks() {
        return bookInfo;
    }

    public BookEntry getBookById(int bookId) {
        return bookInfo.get(bookId);
    }
}




