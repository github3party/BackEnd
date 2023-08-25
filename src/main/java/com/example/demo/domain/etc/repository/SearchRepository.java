package com.example.demo.domain.etc.repository;

import com.example.demo.domain.etc.entity.Alarm;
import com.example.demo.domain.etc.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<Search, Long> {
}
