package com.example.demo.domain.sport.repository;

import com.example.demo.domain.sport.entity.LikeComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeCommentRepository extends JpaRepository<LikeComment, Long> {
}
