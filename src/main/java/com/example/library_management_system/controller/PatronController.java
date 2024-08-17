package com.example.library_management_system.controller;

import com.example.library_management_system.dto.ApiResponse;
import com.example.library_management_system.dto.BaseFilterDto;
import com.example.library_management_system.dto.PatronDto;
import com.example.library_management_system.service.PatronService;
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
@RequestMapping("patrons")
public class PatronController {

    private final PatronService patronService;

    @GetMapping
    public ApiResponse<PatronDto> findAll(BaseFilterDto filter) {
        return patronService.findAll(filter);
    }

    @GetMapping("{id}")
    public ApiResponse<PatronDto> findById(@PathVariable Long id) {
        return patronService.findById(id);
    }

    @PostMapping
    public ApiResponse<PatronDto> add(@Valid @RequestBody PatronDto patronDto) {
        return patronService.add(patronDto);
    }

    @PutMapping("{id}")
    public ApiResponse<PatronDto> update(@PathVariable Long id, @Valid @RequestBody PatronDto patronDto) {
        return patronService.update(id, patronDto);
    }

    @DeleteMapping("{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        return patronService.delete(id);
    }


}
