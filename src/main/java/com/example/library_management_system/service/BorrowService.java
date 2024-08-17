package com.example.library_management_system.service;

import com.example.library_management_system.domain.model.Book;
import com.example.library_management_system.domain.model.BorrowingRecord;
import com.example.library_management_system.domain.model.Patron;
import com.example.library_management_system.domain.repository.BookRepo;
import com.example.library_management_system.domain.repository.BorrowingRecordRepo;
import com.example.library_management_system.domain.repository.PatronRepo;
import com.example.library_management_system.dto.ApiResponse;
import com.example.library_management_system.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
@Service
public class BorrowService {

    private final BookRepo bookRepo;
    private final PatronRepo patronRepo;
    private final BorrowingRecordRepo borrowingRecordRepo;

    public void borrowBook(Long bookId, Long patronId) {
        if (!bookRepo.existsById(bookId)) {
            throw new NotFoundException("book not found -- id = " + bookId);
        }

        if (!patronRepo.existsById(patronId)) {
            throw new NotFoundException("patron not found -- id = " + patronId);
        }

        borrowingRecordRepo.save(new BorrowingRecord(new Book(bookId), new Patron(patronId), LocalDate.now(), null));
    }

    public void returnBook(Long bookId, Long patronId) {

        if (!borrowingRecordRepo.existsByBook_IdAndPatron_Id(bookId, patronId)) {
            throw new NotFoundException("borrowing record not found");
        }
    }
}
