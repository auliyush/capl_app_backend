package caplcom.codingAge.capl.Models.request.CreateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StatsRequest {

    private String matchId;
    private String teamId;
    private String playerId;
    private int totalRuns;
    private double strikeRate;
    private double economyRate;
    private double totalBalls;
    private int totalFours;
    private int totalSix;
}