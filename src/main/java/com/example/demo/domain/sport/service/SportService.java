package com.example.demo.domain.sport.service;

import com.example.demo.domain.category.entity.Category;
import com.example.demo.domain.category.repository.CategoryRepository;
import com.example.demo.domain.etc.entity.Alarm;
import com.example.demo.domain.etc.repository.AlarmRepository;
import com.example.demo.domain.sport.dto.res.ReadSportListResDto;
import com.example.demo.domain.sport.dto.res.ReadSportResDto;
import com.example.demo.domain.sport.repository.SportRepository;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class SportService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final SportRepository sportRepository;
    private final AlarmRepository alarmRepository;
    @Transactional
    public ReadSportListResDto readSportListByCategory(Long userId, Long categoryId) {
        User user = userRepository.findById(userId).orElseThrow();
        Category category = categoryRepository.findById(categoryId).orElseThrow();

        List<ReadSportResDto> readSportResDtos = sportRepository.findByCategory(category).stream()
                .map(sport -> {
                    Alarm alarm = alarmRepository.findByUserAndSport(user, sport);
                    return ReadSportResDto.of(sport, alarm != null);
                })
                .collect(Collectors.toList());

        return ReadSportListResDto.of(category, readSportResDtos);
    }

}
