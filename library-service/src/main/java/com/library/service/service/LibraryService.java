package com.library.service.service;

import com.library.service.entity.LibraryEntity;
import com.library.service.model.BookCreatedEvent;
import com.library.service.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    public void bookadded(BookCreatedEvent event){

        LibraryEntity library = new LibraryEntity();
        library.setIsbn(event.getIsbn());
        library.setName(event.getName());
        library.setAuthor(event.getAuthor());
        library.setYear(event.getYear());

        libraryRepository.save(library);
    }




}
