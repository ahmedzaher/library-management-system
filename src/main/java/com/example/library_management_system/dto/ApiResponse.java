package com.example.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T extends BaseDto> {

    private List<T> content;
    private ApiResponseMeta meta;
    private ApiErrorResponse error;

    public ApiResponse(T element) {
        this.content = Collections.singletonList(element);
        this.meta = ApiResponseMeta.builder()
                .page(1)
                .size(1L)
                .total(1)
                .hasNext(false)
                .build();
    }

    public ApiResponse(List<T> content, Page<?> page) {
       this.content = new ArrayList<>(content);
       this.meta = ApiResponseMeta.builder()
               .page(page.getNumber())
               .size(page.getTotalElements())
               .total(page.getTotalPages())
               .hasNext(page.hasNext())
               .build();
     }
}
