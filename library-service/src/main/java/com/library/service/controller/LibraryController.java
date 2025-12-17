package com.library.service.controller;


import com.library.service.model.BookCreatedEvent;
import com.library.service.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/library/books")
public class LibraryController {

    @Autowired
    LibraryService libraryService;
    @PostMapping
    public ResponseEntity<Map<String, String>> saveBook(
            @RequestBody BookCreatedEvent event) {

        libraryService.bookadded(event);

        System.out.println("BOOK RECEIVED IN LIBRARY SERVICE → " + event.getName());

        return ResponseEntity.ok(
                Map.of("message", "Book saved in library DB")
        );
    }
}
