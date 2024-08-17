package com.example.library_management_system.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class BorrowingRecord extends BaseModel{

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;

    @Column(name = "borrowing_date", nullable = false)
    private LocalDate borrowingDate;

    @Column(name = "returning_date", nullable = false)
    private LocalDate returningDate;

    public BorrowingRecord(Book book, Patron patron, LocalDate borrowingDate, LocalDate returningDate) {
        this.book = book;
        this.patron = patron;
        this.borrowingDate = borrowingDate;
        this.returningDate = returningDate;
    }
}
