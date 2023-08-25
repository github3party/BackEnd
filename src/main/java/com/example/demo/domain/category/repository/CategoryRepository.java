package com.example.demo.domain.category.repository;

import com.example.demo.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByType(String category);
}
