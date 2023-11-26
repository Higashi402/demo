package com.example.demo.utils;

public class BookRequest {

    private String bookTitle;
    private String bookAuthor;


    public BookRequest(String bookTitle, String bookAuthor) {

        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;

    }



    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

}
