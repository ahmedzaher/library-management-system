package com.example.library_management_system.domain.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Patron extends BaseModel {

    private String name;
    private String contractInfo;

    public Patron(Long id) {
        this.id = id;
    }
}
