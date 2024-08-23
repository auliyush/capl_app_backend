package caplcom.codingAge.capl.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
    private Integer matchDate;
    private Integer matchTime;
    private double overs;
    private boolean matchStatus;
    private String tossWonTeamId;
    private String selectionOfTossWinningTeam;
    private String manOfTheMatchPlayerId;
    private ScoreBoard scoreBoard;
    private List<Stats> players;
}
