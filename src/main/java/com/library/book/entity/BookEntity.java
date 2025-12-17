package com.library.book.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class BookEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column
   private UUID id;
   private int isbn;
   private String name;
   private String author;
   private int year;
   private double price;

public BookEntity(){
}

public BookEntity(UUID id,int isbn,String name,String author,int year,double price){
  this.id = id;
  this.isbn = isbn;
  this.name = name;
  this.author = author;
  this.year = year;
  this.price = price;
}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
     return "BookEntity{"+
             "id="+id+
             ",isbn="+isbn+
             ",name="+name+
             ",author="+author+
             ",year="+year+
             ",price="+price+
             '}';
    }
}
