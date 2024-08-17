package com.example.library_management_system.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class PatronDto extends BaseDto {

    private String name;
    private String contractInfo;

}
