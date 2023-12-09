package com.example.demo.utils;

public class BookRequest {

    private Book book;
    private RequestStatus requestStatus;


    public BookRequest(Book book, RequestStatus requestStatus) {
        this.book = book;
        this.requestStatus = requestStatus;
    }

    public String getBookTitle() {
        return book.getTitle();
    }

    public String getBookAuthor() {
        return book.getAuthor();
    }

    public void setRequestStatus(RequestStatus status)
    {
        this.requestStatus = status;
    }
    public RequestStatus getRequestStatus() {
        return requestStatus;
    }
}
