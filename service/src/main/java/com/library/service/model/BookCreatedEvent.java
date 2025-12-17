package com.library.service.model;

public class BookCreatedEvent {
    private int isbn;
    private String name;
    private String author;
    private int year;

    public BookCreatedEvent(){}

    public BookCreatedEvent(int isbn,String name,String author,int year){
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getIsbn(){
        return isbn;
    }
    public void setIsbn(int isbn){
        this.isbn = isbn;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
}
