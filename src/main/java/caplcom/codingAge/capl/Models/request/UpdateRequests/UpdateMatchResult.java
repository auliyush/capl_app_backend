package caplcom.codingAge.capl.Models.request.UpdateRequests;

import caplcom.codingAge.capl.Models.ScoreBoard;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UpdateMatchResult {
    private String matchResultId;
    private String matchId;
    private Integer firstTeamTotalRuns;
    private Integer secondTeamTotalRuns;
    private Integer firstTeamTotalWickets;
    private Integer secondTeamTotalWickets;
    private String winnerTeamId;
    private String manOfTheMatchId;
}

