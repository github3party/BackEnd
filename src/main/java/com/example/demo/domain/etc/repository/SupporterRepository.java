package com.example.demo.domain.etc.repository;

import com.example.demo.domain.etc.entity.Search;
import com.example.demo.domain.etc.entity.Supporter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupporterRepository extends JpaRepository<Supporter, Long> {
}
