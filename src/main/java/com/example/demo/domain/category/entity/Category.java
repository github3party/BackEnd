package com.example.demo.domain.category.entity;

import com.example.demo.domain.sport.entity.Sport;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "category_id", nullable = false)
    private Long categoryId;

    private String type;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LikeCategory> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sport> sportList = new ArrayList<>();

    @Builder
    public Category(String type) {
        this.type = type;
    }

    public static Category of(String type){
        return Category.builder()
                .type(type)
                .build();
    }
}
