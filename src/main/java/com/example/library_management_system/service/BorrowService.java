package com.example.library_management_system.service;

import com.example.library_management_system.domain.model.Book;
import com.example.library_management_system.domain.model.BorrowingRecord;
import com.example.library_management_system.domain.model.Patron;
import com.example.library_management_system.domain.repository.BookRepo;
import com.example.library_management_system.domain.repository.BorrowingRecordRepo;
import com.example.library_management_system.domain.repository.PatronRepo;
import com.example.library_management_system.exception.BadRequestException;
import com.example.library_management_system.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
@Service
public class BorrowService {

    private final BookRepo bookRepo;
    private final PatronRepo patronRepo;
    private final BorrowingRecordRepo borrowingRecordRepo;


    @Transactional
    public void borrowBook(Long bookId, Long patronId) {
        if (!bookRepo.existsById(bookId)) {
            throw new NotFoundException("book not found -- id = " + bookId);
        }

        if (!patronRepo.existsById(patronId)) {
            throw new NotFoundException("patron not found -- id = " + patronId);
        }

        if (borrowingRecordRepo.existsByBook_IdAndReturningDateNot(bookId, null)) {
            throw new BadRequestException("book already borrowed -- id = " + patronId);

        }

        borrowingRecordRepo.save(new BorrowingRecord(new Book(bookId), new Patron(patronId), LocalDate.now(), null));
    }

    @Transactional
    public void returnBook(Long bookId, Long patronId) {
        var b = borrowingRecordRepo.findByBook_IdAndPatron_IdAndReturningDate(bookId, patronId, null)
                .orElseThrow(() -> new NotFoundException("borrowing record not found"));
        b.setReturningDate(LocalDate.now());
    }
}
