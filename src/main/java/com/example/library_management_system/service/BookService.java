package com.example.library_management_system.service;

import com.example.library_management_system.domain.repository.BookRepo;
import com.example.library_management_system.dto.ApiResponse;
import com.example.library_management_system.dto.BookDto;
import com.example.library_management_system.dto.BookFilter;
import com.example.library_management_system.exception.NotFoundException;
import com.example.library_management_system.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {

    private final BookMapper bookMapper;
    private final BookRepo bookRepo;

    public ApiResponse<BookDto> findAll(BookFilter filter) {
        var page = bookRepo.findAll(PageRequest.of(filter.getPage() - 1, filter.getSize()));

        return new ApiResponse<>(bookMapper.map(page.getContent()), page);
    }

    public ApiResponse<BookDto> findById(Long id) {
        return bookRepo.findById(id).map(
                b -> new ApiResponse<>(bookMapper.map(b))
        ).orElseThrow(
                () -> new NotFoundException("book not found -- id = " + id)
        );
    }

    public ApiResponse<BookDto> add(BookDto bookDto) {
        var book = bookRepo.save(bookMapper.map(bookDto));
        return new ApiResponse<>(bookMapper.map(book));
    }

    public ApiResponse<BookDto> update(Long id, BookDto bookDto) {
        var book = bookRepo.findById(id).orElseThrow(
                () -> new NotFoundException("book not found -- id = " + id)
        );
        bookMapper.map(book, bookDto);
        bookRepo.save(book);
        return new ApiResponse<>(bookMapper.map(book));
    }

    public ApiResponse<?> delete(Long id) {
        var book = bookRepo.findById(id).orElseThrow(
                () -> new NotFoundException("book not found -- id = " + id)
        );
        bookRepo.delete(book);
        return new ApiResponse<>();
    }
}
