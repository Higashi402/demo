package com.example.demo.utils;

public class Book {
    private int id;
    private String title;
    private String author;
    private float rating;
    private int amount;
    private int voters;


    public Book(){}

    public Book(String title, String author, float rating, int amount, int voters) {
        this.title = title;
        this.author = author;
        this.amount = amount;
        this.rating = rating;
        this.voters = voters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getVoters() {return this.voters;}

    public void setVoters(int voters) {this.voters = voters;}






}
