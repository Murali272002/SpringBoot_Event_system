package com.library.book.client;

import com.library.book.model.BookCreatedEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class LibraryClient {

    private final RestTemplate restTemplate;

    public LibraryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendToLibrary(BookCreatedEvent event) {
        restTemplate.postForObject(
                "http://localhost:8082/library/books",
                event,
                Void.class
        );

        System.out.println("EVENT SENT TO LIBRARY SERVICE");
    }
}
