package com.example.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseMeta {
    private Integer page;
    private Long size;
    private Integer total;
    private boolean hasNext;
}
