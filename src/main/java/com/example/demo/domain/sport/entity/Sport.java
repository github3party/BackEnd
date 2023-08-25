package com.example.demo.domain.sport.entity;

import com.example.demo.domain.category.entity.Category;
import com.example.demo.domain.etc.entity.Alarm;
import com.example.demo.domain.etc.entity.Supporter;
import com.example.demo.domain.sport.entity.LikeSport;
import com.example.demo.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Sport")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "sport_id", nullable = false)
    private Long sportId;

    @Column(name = "started_game")
    private String startedGame;

    @Column(name = "end_game")
    private String endGame;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alarm> alarmList = new ArrayList<>();

    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LikeSport> likeSportList = new ArrayList<>();

    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Supporter> supporterList = new ArrayList<>();

}
