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
    private String id;
    private String tournamentId;
    private String firstTeamId;
    private String secondTeamId;
    private Date matchDate;
    private Time matchTime;
    private String tossWon;
    private String tossSelected;
    private ScoreBoard ScoreCard;
}

