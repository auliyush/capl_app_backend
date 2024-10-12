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
    private String playerNickName = "";
    private String playerPhone;
    private String playerEmail;
    private String playerPassword;
    private String playerDob;
    private String playerAddress = "";
    private String playerType = "";
    private String playerSubType = "";
    private Integer jerseyNumber;
    private boolean inTeam;
    private float economyRate;
    private float strikeRate;
    private int highestScore;
    private int totalHalfCentury;
    private int totalFullCentury;
    private float playerAverage;
    private int totalMatches;
    private int totalBalls;
    private int totalRuns;
    private int totalFours;
    private int totalSixes;
    // List of stats and list of wicket
}
