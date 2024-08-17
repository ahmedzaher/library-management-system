package com.example.library_management_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookDto extends BaseDto {

    @NotBlank(message = "title required")
    @Size(min = 4, max = 255, message = "title size must be between 4 & 255")
    private String title;

    @NotBlank(message = "author required")
    @Size(min = 4, max = 255, message = "author size must be between 4 & 255")
    private String author;

    @NotNull(message = "publicationYear required")
    private LocalDate publicationYear;

    @Size(min = 10, max = 13, message = "isbn size must be between 4 & 255")
    private String isbn;

}
