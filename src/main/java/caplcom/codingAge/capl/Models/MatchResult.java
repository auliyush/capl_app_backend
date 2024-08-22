package caplcom.codingAge.capl.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="MatchResult")
public class MatchResult {
    @Id
    private String id;
    private String matchId;
    private String tournamentId;
    private String firstTeamId;
    private String secondTeamId;
    private Date matchDate;
    private Time matchTime;
    private String tossWon;
    private String tossSelected;
    private ScoreBoard ScoreCard;
}
