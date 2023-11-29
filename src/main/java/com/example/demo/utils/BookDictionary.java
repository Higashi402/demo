package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class BookDictionary {
    private Map<Integer, BookEntry> bookInfo = new HashMap<>();

    public static BookDictionary createBookDictionaryWithInitialData() {
        BookDictionary bookDictionary = new BookDictionary();
        bookDictionary.addBook(1, "Master and Margaret", "M. Bulgakov", 10, 3);
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
    public int getDictionarySize() {
        return bookInfo.size();
    }

    public void updateBookById(int id, String newTitle, String newAuthor, int newAmount, double newRating) {
        BookEntry bookToUpdate = bookInfo.get(id);
        if (bookToUpdate != null) {
            bookToUpdate.setTitle(newTitle);
            bookToUpdate.setAuthor(newAuthor);
            bookToUpdate.setAmount(newAmount);
            bookToUpdate.setRating(newRating);
            // Заменяем старую запись новой
            bookInfo.put(id, bookToUpdate);
        } else {
            // Если книга с заданным id не найдена, можно сгенерировать ошибку или выполнить другую логику
            // Например, можно выбросить исключение или записать в лог сообщение о неудаче
            // throw new IllegalArgumentException("Книга с id " + id + " не найдена.");
            // или
            // logger.error("Книга с id {} не найдена", id);
        }
    }
}




