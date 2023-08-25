package com.example.demo.domain.sport.service;

import com.example.demo.domain.etc.repository.AlarmRepository;
import com.example.demo.domain.sport.dto.req.CreateCommentReqDto;
import com.example.demo.domain.sport.dto.res.*;
import com.example.demo.domain.sport.entity.Comment;
import com.example.demo.domain.sport.entity.Sport;
import com.example.demo.domain.sport.repository.CommentRepository;
import com.example.demo.domain.sport.repository.SportRepository;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final SportRepository sportRepository;
    private final AlarmRepository alarmRepository;
    @Transactional
    public CreateCommentResDto createComment(Long userId, CreateCommentReqDto createCommentReqDto) {
        User user = userRepository.findById(userId).orElseThrow();
        Sport sport = sportRepository.findById(createCommentReqDto.getComment().getSport().getSportId()).orElseThrow();
        return CreateCommentResDto.of(user, sport, createCommentReqDto);
    }

    @Transactional(readOnly = true)
    public ReadCommentListResDto readCommentListBySport(Long sportId) {
        Sport sport = sportRepository.findById(sportId).orElseThrow();
        List<ReadCommentResDto> readCommentResDtos = commentRepository.findBySport(sport).stream()
                .map(ReadCommentResDto::of)
                .collect(Collectors.toList());
        return ReadCommentListResDto.of(sport, readCommentResDtos);
    }

}
