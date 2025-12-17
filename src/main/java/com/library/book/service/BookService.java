package com.library.book.service;

import com.library.book.entity.BookEntity;
import com.library.book.model.Book;
import com.library.book.model.BookCreatedEvent;
import com.library.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    BookEventPublisher publisher;

    public BookService(BookRepository bookRepository,
                       BookEventPublisher publisher) {
        this.bookRepository = bookRepository;
        this.publisher = publisher;
    }

    public Book addBook(Book book){
        BookEntity bookEntity = new BookEntity(book.getId(),book.getIsbn(),book.getName(),book.getAuthor(),book.getYear(),book.getPrice());
         bookRepository.save(bookEntity);

        BookCreatedEvent event = new BookCreatedEvent(
                bookEntity.getIsbn(), bookEntity.getName(), bookEntity.getAuthor(), bookEntity.getYear());

        publisher.publishEvent(event);

          Book book1 = new Book.Builder()
           .id(bookEntity.getId())
           .isbn(bookEntity.getIsbn())
           .name(bookEntity.getName())
           .author(bookEntity.getAuthor())
           .year(bookEntity.getYear())
           .price(bookEntity.getPrice())
           .build();
       return book1;
    }

    public List<Book> getBook(){
      List<BookEntity> bookEntity =  bookRepository.findAll();
      List<Book> book = new ArrayList<>();

      for(int i=0;i<bookEntity.size();i++){
          Book book1 = new Book.Builder()
                  .id(bookEntity.get(i).getId())
                  .isbn(bookEntity.get(i).getIsbn())
                  .name(bookEntity.get(i).getName())
                  .author(bookEntity.get(i).getAuthor())
                  .year(bookEntity.get(i).getYear())
                  .price(bookEntity.get(i).getPrice())
                  .build();
          book.add(book1);
      }
      return book;
    }

    public Book updateBook(UUID id, Book book){
        BookEntity bookEntity = bookRepository.getReferenceById(id);
        bookEntity.setId(id);
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setName(book.getName());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setYear(book.getYear());
        bookEntity.setPrice(book.getPrice());

        bookRepository.save(bookEntity);
        Book book1 = new Book.Builder()
                .id(bookEntity.getId())
                .isbn(bookEntity.getIsbn())
                .name(bookEntity.getName())
                .author(bookEntity.getAuthor())
                .year(bookEntity.getYear())
                .price(bookEntity.getPrice())
                .build();
        return book1;
    }

    public void deleteBook(UUID id){

        BookEntity bookEntity = bookRepository.getReferenceById(id);
        bookRepository.delete(bookEntity);
    }

}
