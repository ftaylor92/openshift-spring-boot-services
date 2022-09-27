package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import com.example.demo.model.Book;
import com.example.demo.repo.BookRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://localhost:4200", "http://2601:18f:702:f970:b0a4:4756:5e91:517b", "https://2601:18f:702:f970:b0a4:4756:5e91:517b", "https://kanbanfire-5712f.web.app", "https://kanbanfire-5712f.web.app"})
public class BookController {

    BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBook(@PathVariable("id") Long id) {
        return bookRepository.findById(id);
    }

    @PostMapping("/books")
    public HttpStatus addBook(@RequestBody Book book){
        bookRepository.save(book);

        return HttpStatus.CREATED;
    }

}
