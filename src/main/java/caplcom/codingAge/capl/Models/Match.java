package caplcom.codingAge.capl.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Match")
@Getter
@Setter
@NoArgsConstructor
public class Match {
    @Id
    private String matchId;
    private String tournamentId;
    private String creatorId;
    private String  firstTeamId;
    private String secondTeamId;
    //  Convert this Integer to Date and Time
    private Integer matchDate;
    private Integer matchTime;
    private double overs;
    private String tossWonTeamId;
    private String selectionOfTossWinningTeam;
    private ScoreBoard scoreBoard;
    // List<TeamStats> need here
}
