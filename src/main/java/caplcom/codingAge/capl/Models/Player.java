package caplcom.codingAge.capl.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Player")
@Getter
@Setter
@NoArgsConstructor
public class Player{
    @Id
    private String playerId;
    private String playerName;
    private String playerProfilePhotoUrl = "";
    private String playerNickName;
    private String playerPhone;
    private String playerEmail;
    private String playerPassword;
    private String playerDob;
    private String playerAddress;
    private String playerType;
    private String playerSubType;
    private Integer jerseyNumber;
    private boolean inTeam;
    private String economyRate;
    private String strikeRate;
    private String highestScore;
    private String totalHalfCentury;
    private String totalFullCentury;
    private String playerAverage;
    private String totalMatches;
    private String totalBalls;
    private String totalRuns;
    private int totalFours;
    private int totalSixes;
    // List of stats and list of wicket
}
