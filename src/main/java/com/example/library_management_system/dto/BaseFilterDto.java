package com.example.library_management_system.dto;

import lombok.Data;

@Data
public class BaseFilterDto {
    protected Integer page = 1;
    protected Integer size = 10;
    protected String keyword;
}
