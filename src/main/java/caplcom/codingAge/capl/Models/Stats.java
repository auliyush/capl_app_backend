package caplcom.codingAge.capl.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection ="stats")
@AllArgsConstructor
@NoArgsConstructor


public class Stats {
    @Id
    private String statsId;

    private String matchId;
    private String teamId;
    private String playerId;
    private int totalRuns;
    private double strikeRate;
    private double economyRate;
    private double totalBalls;
    private int totalFours;
    private int totalSix;
    // 18 Aug. Discuss

    private List<Wicket> wickets = new ArrayList<>();

}