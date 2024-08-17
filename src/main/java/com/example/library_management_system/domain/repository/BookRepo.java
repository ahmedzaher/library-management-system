package com.example.library_management_system.domain.repository;

import com.example.library_management_system.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
}
