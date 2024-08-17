package com.example.library_management_system.controller;


import com.example.library_management_system.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BorrowingRecordController {

    private final BorrowService borrowService;

    @PostMapping("borrow/{bookId}/patron/{patronId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void borrow(@PathVariable Long bookId, @PathVariable Long patronId) {
        borrowService.borrowBook(bookId, patronId);
    }

    @PostMapping("return/{bookId}/patron/{patronId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        borrowService.returnBook(bookId, patronId);
    }
}
