package com.example.demo.utils;

import java.util.Date;

public class Proposal {
    private int id;
    private int libraryUserId;
    private int bookId;
    private String bookTitle;
    private String proposalStatus;
    private String returningDate;
    private String author;

    public Proposal() {}

    public Proposal(int id,int libraryUserId, String proposalStatus, int bookId, String returningDate, String bookTitle,String author) {
        this.libraryUserId = libraryUserId;
        this.bookId = bookId;
        this.returningDate = returningDate;
        this.id = id;
        this.bookTitle = bookTitle;
        this.author = author;
        this.proposalStatus = proposalStatus;
    }

    public int getLibraryUserId() {return libraryUserId;}

    public void setLibraryUserId(int libraryUserId) {this.libraryUserId = libraryUserId;}

    public int getBookId() {return bookId;}

    public void setBookId(int bookId) {this.bookId = bookId;}

    public String getReturningDate() {return returningDate;}

    public void setReturningDate(String returningDate) {this.returningDate = returningDate;}

    public int getId() {return this.id;}

    public void setId(int id) {this.id = id;}

    public String getBookTitle() {return this.bookTitle;}

    public void setBookTitle(String bookTitle) {this.bookTitle = bookTitle;}

    public String getAuthor() {return this.author;}

    public void setAuthor(String author) {this.author = author;}

    public String getProposalStatus() {return this.proposalStatus;}

    public void setProposalStatus(String proposalStatus) {this.proposalStatus = proposalStatus;}
}
