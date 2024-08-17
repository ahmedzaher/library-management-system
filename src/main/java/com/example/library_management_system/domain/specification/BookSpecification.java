package com.example.library_management_system.domain.specification;

import com.example.library_management_system.domain.model.Book;
import com.example.library_management_system.dto.BaseFilterDto;
import com.example.library_management_system.dto.BookFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.criteria.JpaPredicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class BookSpecification implements Specification<Book> {

    private final BookFilter filterDto;

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(filterDto.getKeyword())) {
            predicates.add(
                    cb.or(
                            cb.like(root.get("title"), "%" + filterDto.getKeyword() + "%"),
                            cb.like(root.get("author"), "%" + filterDto.getKeyword() + "%"),
                            cb.like(root.get("isbn"), "%" + filterDto.getKeyword() + "%")
                    )
            );
        }

        if (StringUtils.hasText(filterDto.getAuthor())) {
            predicates.add(cb.equal(root.get("author"), "%" + filterDto.getKeyword() + "%"));
        }

        if (StringUtils.hasText(filterDto.getTitle())) {
            predicates.add(cb.equal(root.get("title"), "%" + filterDto.getTitle() + "%"));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }


}