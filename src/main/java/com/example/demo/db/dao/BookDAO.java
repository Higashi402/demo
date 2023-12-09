package com.example.demo.db.dao;

import com.example.demo.utils.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
    List<Book> getAllBooks() throws SQLException;
}
