package com.example.demo.domain.etc;

import com.example.demo.domain.etc.entity.Alarm;
import com.example.demo.domain.etc.entity.Supporter;
import com.example.demo.domain.etc.repository.AlarmRepository;
import com.example.demo.domain.etc.repository.SupporterRepository;
import com.example.demo.domain.sport.dto.res.ReadSportResDto;
import com.example.demo.domain.etc.dto.ReadSupporterResDto;
import com.example.demo.domain.sport.entity.Sport;
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
public class EtcService {
    private final UserRepository userRepository;
    private final SportRepository sportRepository;

    private final SupporterRepository supporterRepository;
    private final AlarmRepository alarmRepository;

    public List<ReadSportResDto> searchSport(Long userId, String search) {
        User user = userRepository.findById(userId).orElseThrow();
        List<ReadSportResDto> readSportResDtos = sportRepository.findBySportContaining(search).stream()
                .map(sport -> {
                    Alarm alarm = alarmRepository.findByUserAndSport(user, sport);
                    return ReadSportResDto.of(sport, alarm != null);
                })
                .collect(Collectors.toList());
        return readSportResDtos;
    }

    @Transactional
    public ReadSportResDto createdSupporter(Long userId, Long sportId) {
        User user = userRepository.findById(userId).orElseThrow();
        Sport sport = sportRepository.findById(sportId).orElseThrow();

        Supporter supporter = Supporter.of(user, sport);
        supporterRepository.save(supporter);
        Alarm alarm = alarmRepository.findByUserAndSport(user, sport);
        return ReadSportResDto.of(sport, alarm != null);
    }

    public ReadSupporterResDto readSupporter(Long userId, Long sportId) {
        Sport sport = sportRepository.findById(sportId).orElseThrow();
        return ReadSupporterResDto.builder()
                .supporterSum(sport.getSupporterList().size())
                .build();
    }

    @Transactional
    public ReadSportResDto createAlarm(Long userId, Long sportId) {
        User user = userRepository.findById(userId).orElseThrow();
        Sport sport = sportRepository.findById(sportId).orElseThrow();

        Alarm alarm = Alarm.of(user, sport);
        alarmRepository.save(alarm);
        return ReadSportResDto.of(sport, true);
    }
}
