package com.example.library_management_system.domain.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Book extends BaseModel {
    private String title;
    private String author;
    private LocalDate publicationYear;
    private String isbn;

    public Book(Long id) {
        this.id = id;
    }
}
