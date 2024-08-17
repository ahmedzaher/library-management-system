package com.example.library_management_system.controller;

import com.example.library_management_system.dto.ApiResponse;
import com.example.library_management_system.dto.BookDto;
import com.example.library_management_system.dto.BookFilter;
import com.example.library_management_system.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ApiResponse<BookDto> findAll(BookFilter filter) {
        return bookService.findAll(filter);
    }

    @GetMapping("{id}")
    public ApiResponse<BookDto> findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public ApiResponse<BookDto> add(@Valid @RequestBody BookDto bookDto) {
        return bookService.add(bookDto);
    }

    @PutMapping("{id}")
    public ApiResponse<BookDto> update(@PathVariable Long id, @Valid @RequestBody BookDto bookDto) {
        return bookService.update(id, bookDto);
    }

    @DeleteMapping("{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        return bookService.delete(id);
    }
}
