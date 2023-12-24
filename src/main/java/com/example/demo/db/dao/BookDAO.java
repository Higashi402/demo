package com.example.demo.db.dao;

import com.example.demo.utils.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
    List<Book> getAllBooks() throws SQLException;

    Book getBookById(int bookId) throws SQLException;

    void decreaseBookAmountById(int bookId) throws SQLException;

    void addBook(String title, String author, int amount) throws SQLException;

    void deleteBook(int bookId) throws SQLException;

    void updateBook(int bookId, String title, String author, int amount) throws SQLException;
}
