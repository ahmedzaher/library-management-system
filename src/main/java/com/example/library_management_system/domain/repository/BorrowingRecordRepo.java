package com.example.library_management_system.domain.repository;

import com.example.library_management_system.domain.model.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface BorrowingRecordRepo extends JpaRepository<BorrowingRecord, Long>, JpaSpecificationExecutor<BorrowingRecord> {

    Optional<BorrowingRecord> findByBook_IdAndPatron_IdAndReturningDate(Long bookId, Long patronId, LocalDate returningDate);
    boolean existsByBook_IdAndReturningDateNot(Long bookId, LocalDate returningDate);
}
