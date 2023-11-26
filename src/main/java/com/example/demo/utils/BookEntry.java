package com.example.demo.utils;

public class BookEntry {
    private String title;
    private String author;

    private int amount;

    private double rating;

    public BookEntry(String title, String author, int amount, double rating) {
        this.title = title;
        this.author = author;
        this.amount = amount;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getRating() {
        return rating;
    }
}
