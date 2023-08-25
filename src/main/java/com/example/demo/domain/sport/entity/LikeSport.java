package com.example.demo.domain.sport.entity;

import com.example.demo.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LikeSport")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeSport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "like_sport_id", nullable = false)
    private Long ikeCategoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sportId", nullable = false)
    private Sport sport;

}
