package com.example.demo.domain.etc.entity;

import com.example.demo.domain.sport.entity.Sport;
import com.example.demo.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Alarm")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "alarm_id", nullable = false)
    private Long alarmId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sportId", nullable = false)
    private Sport sport;


    @Builder
    public Alarm(User user, Sport sport) {
        this.user = user;
        this.sport = sport;
    }

    public static Alarm of(User user, Sport sport) {
        return Alarm.builder()
                .user(user)
                .sport(sport)
                .build();
    }
}
