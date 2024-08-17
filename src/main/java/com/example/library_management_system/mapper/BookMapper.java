package com.example.library_management_system.mapper;

import com.example.library_management_system.domain.model.Book;
import com.example.library_management_system.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto map(Book arg);
    List<BookDto> map(List<Book> arg);

    Book map(BookDto arg);

    @Mapping(target = "id", ignore = true)
    void map(@MappingTarget Book arg1, BookDto arg2);

}
