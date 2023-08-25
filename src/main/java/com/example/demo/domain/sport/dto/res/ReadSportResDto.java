package com.example.demo.domain.sport.dto.res;

import com.example.demo.domain.sport.entity.Sport;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReadSportResDto {

    @Schema(description = "카테고리 id", defaultValue = "1")
    private Long sportId;
    @Schema(description = "게임시작", defaultValue = "1")
    private String startedGame;

    @Schema(description = "알람유무확인 (true, false)", defaultValue = "false")
    private Boolean alarmCheck;

    private long likeSportSum;
    private long alarmSum;
    private long supporterSum;

    public static ReadSportResDto of(Sport sport, boolean alarmCheck){
        return ReadSportResDto.builder()
                .sportId(sport.getSportId())
                .startedGame(sport.getStartedGame())
                .alarmCheck(alarmCheck)
                .likeSportSum(sport.getLikeSportList().size())
                .alarmSum(sport.getAlarmList().size())
                .supporterSum(sport.getSupporterList().size())
                .build();
    }
}
