package caplcom.codingAge.capl.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection ="BatterStats")
@AllArgsConstructor
@NoArgsConstructor
public class BatterStat {
    @Id
    private String statId;
    private String scoreBoardId;
    private String teamId;
    private String playerId;
    private int totalRuns;
    private double totalBalls;
    private int totalFours;
    private int totalSix;
    private double strikeRate;
}