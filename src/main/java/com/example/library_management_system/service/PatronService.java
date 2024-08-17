package com.example.library_management_system.service;

import com.example.library_management_system.domain.repository.PatronRepo;
import com.example.library_management_system.dto.ApiResponse;
import com.example.library_management_system.dto.BaseFilterDto;
import com.example.library_management_system.dto.PatronDto;
import com.example.library_management_system.exception.NotFoundException;
import com.example.library_management_system.mapper.PatronMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PatronService {

    private final PatronMapper patronMapper;
    private final PatronRepo patronRepo;

    public ApiResponse<PatronDto> findAll(BaseFilterDto filter) {
         var page = patronRepo.findAll(PageRequest.of(filter.getPage() - 1, filter.getSize()));

         return new ApiResponse<>(patronMapper.map(page.getContent()), page);
    }

    public ApiResponse<PatronDto> findById(Long id) {
        return patronRepo.findById(id).map(
                b -> new ApiResponse<>(patronMapper.map(b))
        ).orElseThrow(
                () -> new NotFoundException("patron not found -- id = " + id)
        );
    }

    public ApiResponse<PatronDto> add(PatronDto patronDto) {
        var patron = patronRepo.save(patronMapper.map(patronDto));
        return new ApiResponse<>(patronMapper.map(patron));
    }

    public ApiResponse<PatronDto> update(Long id, PatronDto patronDto) {
        var patron = patronRepo.findById(id).orElseThrow(
                () -> new NotFoundException("patron not found -- id = " + id)
        );
        patronMapper.map(patron, patronDto);
        patronRepo.save(patron);
        return new ApiResponse<>(patronMapper.map(patron));
    }

    public ApiResponse<?> delete(Long id) {
        var patron = patronRepo.findById(id).orElseThrow(
                () -> new NotFoundException("patron not found -- id = " + id)
        );
        patronRepo.delete(patron);
        return new ApiResponse<>();
    }
}
