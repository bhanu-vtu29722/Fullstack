package com.library.bookservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.library.bookservice.entity.Book;
import com.library.bookservice.repository.BookRepository;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository repository;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @PutMapping("/{id}/availability")
    public Book updateAvailability(@PathVariable Long id, @RequestParam boolean status) {
        Book book = repository.findById(id).orElseThrow();
        book.setAvailable(status);
        return repository.save(book);
    }
}
