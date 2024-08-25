package caplcom.codingAge.capl.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "player")
@Getter
@Setter
@NoArgsConstructor
public class Player extends User{
    private String playerDob;
    private String playerAddress;
    private String playerType;
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
