package com.example.library_management_system.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "borrowing_record",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "patron_id")
    )
    private List<Patron> patrons;

    public Book(Long id) {
        this.id = id;
    }
}
