package com.example.demo.db.oracledao;

import com.example.demo.db.dao.BookDAO;
import com.example.demo.utils.Book;

import java.sql.*;
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
    public Book getBookById(int bookId) throws SQLException {
        Book book = null;
        String query = "SELECT * FROM \"BOOKS\" WHERE BOOKID = " + bookId;
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            book = new Book();
            book.setId(resultSet.getInt("BOOKID"));
            book.setTitle(resultSet.getString("TITLE"));
            book.setAuthor(resultSet.getString("AUTHOR"));
            book.setRating(resultSet.getFloat("RATING"));
            book.setAmount(resultSet.getInt("AMOUNT"));
            book.setVoters(resultSet.getInt("VOTERS"));
        }
        return book;
    }

    @Override
    public void decreaseBookAmountById(int bookId) throws SQLException {
        String updateQuery = "UPDATE \"BOOKS\" SET AMOUNT = AMOUNT - 1 WHERE BOOKID = " + bookId;
        Statement statement = this.getConnection().createStatement();
        statement.executeQuery(updateQuery);
    }

    @Override
    public void addBook(String title, String author, int amount) throws SQLException {
        Statement statement = this.getConnection().createStatement();
        statement.executeQuery("INSERT INTO BOOKS(TITLE,AUTHOR,RATING,AMOUNT,VOTERS) VALUES(" + "'" + title + "'" + ",'" + author + "', 0," + amount + ",0)");
    }

    @Override
    public void deleteBook(int bookId) throws SQLException {
        Statement statement = this.getConnection().createStatement();
        Statement statement1= this.getConnection().createStatement();
        statement1.executeQuery("DELETE FROM BOOKPROPOSAL WHERE BOOK =" + bookId);
        statement.executeQuery("DELETE FROM BOOKS WHERE BOOKID =" + bookId);
    }

    @Override
    public void updateBook(int bookId, String title, String author, int amount) throws SQLException {
        Connection connection = this.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE BOOKS SET TITLE = ?, AUTHOR = ?, AMOUNT = ? WHERE BOOKID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setInt(3, amount);
            preparedStatement.setInt(4, bookId);

            // Выполнение запроса на обновление
            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
