package com.olehpodolin.spring5mvcrest.repositories;

import com.olehpodolin.spring5mvcrest.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
