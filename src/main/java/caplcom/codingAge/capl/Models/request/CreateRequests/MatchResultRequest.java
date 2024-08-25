package caplcom.codingAge.capl.Models.request.CreateRequests;

import caplcom.codingAge.capl.Models.ScoreBoard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class MatchResultRequest {
    private String matchId;
    private String tournamentId;
    private String firstTeamId;
    private String secondTeamId;
    private Integer firstTeamTotalRuns;
    private Integer secondTeamTotalRuns;
    private Integer firstTeamTotalWickets;
    private Integer secondTeamTotalWickets;
}
