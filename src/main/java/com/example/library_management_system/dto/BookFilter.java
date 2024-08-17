package com.example.library_management_system.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookFilter extends BaseFilterDto{

    private String title;
    private String author;
}
