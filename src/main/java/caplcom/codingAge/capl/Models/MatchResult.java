package caplcom.codingAge.capl.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="MatchResult")
public class MatchResult {
    @Id
    private String matchResultId;
    private String matchId;
    private String tournamentId;
    private String firstTeamId;
    private String secondTeamId;
    private Integer firstTeamTotalRuns;
    private Integer secondTeamTotalRuns;
    private Integer firstTeamTotalWickets;
    private Integer secondTeamTotalWickets;
    private String winnerTeamId;
    private String manOfTheMatchId;
}
