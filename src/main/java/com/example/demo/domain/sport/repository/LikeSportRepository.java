package com.example.demo.domain.sport.repository;

import com.example.demo.domain.sport.entity.LikeSport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeSportRepository extends JpaRepository<LikeSport, Long> {
}
