package com.example.demo.domain.etc.repository;

import com.example.demo.domain.etc.entity.Alarm;
import com.example.demo.domain.sport.entity.Sport;
import com.example.demo.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
    Alarm findByUserAndSport(User user, Sport sport);
}
