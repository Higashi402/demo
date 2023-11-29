package com.example.demo.utils;

public class BookRequest {

    private BookEntry book;
    private String status;


    public BookRequest(BookEntry book, String status) {
        this.book = book;
        this.status = status;
    }

    public String getBookTitle() {
        return book.getTitle();
    }

    public String getBookAuthor() {
        return book.getAuthor();
    }

    public String getRequestStatus() {
        return status;
    }
}
