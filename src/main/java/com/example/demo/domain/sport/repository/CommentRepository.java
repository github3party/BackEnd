package com.example.demo.domain.sport.repository;

import com.example.demo.domain.sport.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
