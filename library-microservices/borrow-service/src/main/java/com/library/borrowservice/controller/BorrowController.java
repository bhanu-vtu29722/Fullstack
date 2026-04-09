package com.library.borrowservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import com.library.borrowservice.entity.Borrow;
import com.library.borrowservice.repository.BorrowRepository;

@RestController
@RequestMapping("/borrow")
@RequiredArgsConstructor
public class BorrowController {

    private final BorrowRepository repository;
    private final RestTemplate restTemplate;

    @PostMapping
    public Borrow borrowBook(@RequestBody Borrow borrow) {

        // Check User Exists
        restTemplate.getForObject(
                "http://localhost:8081/users/" + borrow.getUserId(),
                Object.class);

        // Check Book Exists
        restTemplate.getForObject(
                "http://localhost:8082/books",
                Object.class);

        borrow.setBorrowDate(LocalDate.now());
        return repository.save(borrow);
    }
}
