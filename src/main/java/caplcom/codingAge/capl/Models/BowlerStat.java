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
@Document(collection ="BowlerStats")
@AllArgsConstructor
@NoArgsConstructor
public class BowlerStat {
    @Id
    private String statId;
    private String scoreBoardId;
    private String teamId;
    private String playerId;
    private int totalRuns;
    private double totalBalls;
    private int totalFours;
    private int totalSix;
    private double economyRate;
    private List<Wicket> wicketsList = new ArrayList<>();
}
