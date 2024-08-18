package com.example.library_management_system.ut.service;

import com.example.library_management_system.domain.repository.BookRepo;
import com.example.library_management_system.domain.repository.BorrowingRecordRepo;
import com.example.library_management_system.domain.repository.PatronRepo;
import com.example.library_management_system.exception.BadRequestException;
import com.example.library_management_system.exception.NotFoundException;
import com.example.library_management_system.service.BorrowService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class BorrowServiceTests {

    @Autowired
    private BorrowService borrowService;

    @MockBean
    private BorrowingRecordRepo borrowingRecordRepo;

    @MockBean
    private BookRepo bookRepo;

    @MockBean
    private PatronRepo patronRepo;


    @Test
    void testBorrow() {
        Mockito.when(bookRepo.existsById(any())).thenReturn(true);
        Mockito.when(patronRepo.existsById(any())).thenReturn(true);
        Mockito.when(borrowingRecordRepo.existsByBook_IdAndReturningDateNot(any(), any())).thenReturn(false);
        borrowService.borrowBook(1L, 1L);
        assertTrue(true);
    }

    @Test
    void testBorrowGiveBookNotFoundThen404() {
        Mockito.when(bookRepo.existsById(any())).thenReturn(false);

        assertThrows(NotFoundException.class,
                ()-> borrowService.borrowBook(1L, 1L));
    }

    @Test
    void testBorrowGiveBookBorrowedThen400() {
        Mockito.when(bookRepo.existsById(any())).thenReturn(true);
        Mockito.when(patronRepo.existsById(any())).thenReturn(true);
        Mockito.when(borrowingRecordRepo.existsByBook_IdAndReturningDateNot(any(), any())).thenReturn(true);

        assertThrows(BadRequestException.class,
                ()-> borrowService.borrowBook(1L, 1L));
    }
}
