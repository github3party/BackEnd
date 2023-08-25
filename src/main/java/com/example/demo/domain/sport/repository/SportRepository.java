package com.example.demo.domain.sport.repository;

import com.example.demo.domain.sport.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {
}
