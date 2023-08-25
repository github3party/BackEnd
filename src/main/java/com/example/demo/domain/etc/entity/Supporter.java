package com.example.demo.domain.etc.entity;

import com.example.demo.domain.sport.entity.Sport;
import com.example.demo.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Supporter")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Supporter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "supporter_id", nullable = false)
    private Long supporterId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sportId", nullable = false)
    private Sport sport;

}
