package com.thd.springapi.APIPractice.Model;

public class Book {

    private String title;
    private String author;
    private String publisher;
    private String description;

    public Book(String title, String author, String publisher, String description) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
    }

    public Book() {

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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
