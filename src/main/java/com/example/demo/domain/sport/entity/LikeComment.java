package com.example.demo.domain.sport.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LikeComment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "like_comment_id", nullable = false)
    private Long likeCommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment", nullable = false)
    private Comment comment;
}
