package com.example.demo.domain.sport.repository;

import com.example.demo.domain.category.entity.Category;
import com.example.demo.domain.sport.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportRepository extends JpaRepository<Sport, Long> {
    List<Sport> findByCategory(Category category);
}
