package com.library.book.controller;

import com.library.book.entity.BookEntity;
import com.library.book.model.Book;
import com.library.book.model.BookCreatedEvent;
import com.library.book.service.BookEventPublisher;
import com.library.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    BookService bookService;

    private final BookEventPublisher publisher;

    public BookController(BookEventPublisher publisher){
            this.publisher = publisher;
    }

    @PostMapping
    public String addBook(@RequestBody BookCreatedEvent event) {
        publisher.publishEvent(event);
        return "Book created & event sent";
    }

    @GetMapping("/getName")
    public String getName(){
        return "Muralidharan.N";
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/get-book")
    public List<Book> getBook(){
        return bookService.getBook();
    }

    @PutMapping("update-book/{id}")
    public Book updateBook(@PathVariable UUID id, @RequestBody Book book){
        return bookService.updateBook(id,book);
    }

    @DeleteMapping("delete-book/{id}")
    public void deleteBook(@PathVariable UUID id){
        bookService.deleteBook(id);
    }
}
