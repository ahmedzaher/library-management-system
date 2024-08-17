package com.example.library_management_system.mapper;

import com.example.library_management_system.domain.model.Patron;
import com.example.library_management_system.dto.PatronDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatronMapper {

    PatronDto map(Patron arg);
    List<PatronDto> map(List<Patron> arg);

    Patron map(PatronDto arg);

    @Mapping(target = "id", ignore = true)
    void map(@MappingTarget Patron arg1, PatronDto arg2);

}
