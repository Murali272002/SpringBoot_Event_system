package com.library.book.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.UUID;

@JsonDeserialize(builder = Book.Builder.class)
public class Book {

    private UUID id;
    private int isbn;
    private String name;
    private String author;
    private int year;
    private double price;

    private Book(){}

    public int getIsbn() {
        return isbn;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @JsonPOJOBuilder(withPrefix = "")
public static class Builder{
  private Book book;
  public Builder(){book  = new Book(); }

  public Builder id(UUID id){
  book.id = id;
  return this;
  }
  public Builder isbn(int isbn){
      book.isbn = isbn;
      return this;
  }
  public Builder name(String name){
      book.name = name;
      return this;
  }
  public Builder author(String author){
      book.author = author;
      return this;
  }
  public Builder year(int year){
      book.year = year;
      return this;
  }
  public Builder price(double price){
      book.price = price;
      return this;
  }
  public Book build(){return book;}
}

@Override
  public String toString(){
    return "Book{"+
        "id=" +id+
                ",isbn="+isbn+'\''+
                ",name=" +name+'\''+
                ",author=" +author+'\''+
                ",year="+year+'\''+
                ",price=" +price+'\''+
            '}';
  }
}
