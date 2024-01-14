package com.example.demo.utils;

public class Issuance {
    private int bookProposal;
    private String issuanceDate;
    private String actualReturningDate;
    private String bookTitle;
    private String author;
    private String userLogin;


    public int getBookProposal() {return this.bookProposal;}

    public String getIssuanceDate(){return this.issuanceDate;}

    public String getActualReturningDate() {return this.actualReturningDate;}

    public String getAuthor() {return this.author;}

    public String getBookTitle() {return this.bookTitle;}

    public String getUserLogin() {return this.userLogin;}

    public void setBookProposal(int bookProposal) {
        this.bookProposal = bookProposal;
    }

    public void setIssuanceDate(String issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    public void setActualReturningDate(String actualReturningDate) {
        this.actualReturningDate = actualReturningDate;
    }

    public void setBookTitle(String bookTitle) {this.bookTitle = bookTitle;}

    public void setAuthor(String author) {this.author = author;}

    public void setUserLogin(String userLogin) {this.userLogin = userLogin;}
}
