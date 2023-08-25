package com.example.demo.domain.category.entity;

import com.example.demo.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LikeCategory")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "like_category_id", nullable = false)
    private Long likeCategoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @Builder
    public LikeCategory(User user, Category category) {
        this.user = user;
        this.category = category;
    }

    public static LikeCategory of(User user, Category category){
        return LikeCategory.builder()
                .user(user)
                .category(category)
                .build();
    }
}
