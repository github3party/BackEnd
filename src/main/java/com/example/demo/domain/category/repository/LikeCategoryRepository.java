package com.example.demo.domain.category.repository;

import com.example.demo.domain.category.entity.Category;
import com.example.demo.domain.category.entity.LikeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeCategoryRepository extends JpaRepository<LikeCategory, Long> {
}
