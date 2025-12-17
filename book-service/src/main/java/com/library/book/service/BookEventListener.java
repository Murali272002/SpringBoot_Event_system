package com.library.book.service;

import com.library.book.client.LibraryClient;
import com.library.book.model.BookCreatedEvent;
import org.springframework.jms.annotation.JmsListener;
import com.library.book.messaging.JmsConstant;
import org.springframework.stereotype.Service;

@Service
public class BookEventListener {

    private final LibraryClient libraryClient;

    public BookEventListener(LibraryClient libraryClient) {
        this.libraryClient = libraryClient;
    }

    @JmsListener(destination = JmsConstant.BOOK_CREATED_QUEUE)
    public void listen(BookCreatedEvent event) {
        System.out.println("EVENT RECEIVED FROM ACTIVEMQ → " + event.getName());

        // Call Library Service API
        libraryClient.sendToLibrary(event);
    }
}
