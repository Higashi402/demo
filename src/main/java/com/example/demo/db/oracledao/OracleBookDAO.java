package com.example.demo.db.oracledao;

import com.example.demo.db.dao.BookDAO;
import com.example.demo.roles.RoleType;
import com.example.demo.utils.Book;
import com.example.demo.utils.ConfigurationManager;
import com.example.demo.utils.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleBookDAO implements BookDAO {

    private Connection connection;

    public OracleBookDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"BOOKS\"");
        Book book = new Book();
        while(resultSet.next()) {
            book = new Book();
            book.setId(resultSet.getInt("BOOKID"));
            book.setTitle(resultSet.getString("TITLE"));
            book.setAuthor(resultSet.getString("AUTHOR"));
            book.setRating(resultSet.getFloat("RATING"));
            book.setAmount(resultSet.getInt("AMOUNT"));
            book.setVoters(resultSet.getInt("VOTERS"));
            books.add(book);
        }
        return books;
    }

    @Override
    public void addBook(String title, String author, int amount) throws SQLException {
        Statement statement = this.getConnection().createStatement();
        statement.executeQuery("INSERT INTO BOOKS(TITLE,AUTHOR,RATING,AMOUNT,VOTERS) VALUES(" + "'" + title + "'" + ",'" + author + "', 0," + amount + ",0)");
    }

    @Override
    public void deleteBook(int bookId) throws SQLException {
        Statement statement = this.getConnection().createStatement();
        statement.executeQuery("DELETE FROM BOOKS WHERE BOOKID =" + bookId);
    }
}
