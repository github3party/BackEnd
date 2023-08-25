package com.example.demo.domain.sport.repository;

import com.example.demo.domain.sport.entity.Comment;
import com.example.demo.domain.sport.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findBySport(Sport sport);
}
