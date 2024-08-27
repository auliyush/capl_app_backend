package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.BatterStat;

public interface BatterStatService {
    BatterStat createInningBatterStats(String scoreBoardId, String teamId, String playerId);
    BatterStat getBatterStatByPlayerId(String playerId, String scoreBoardId);

    boolean addRunInStriker(String strikerId, int run);
     BatterStat getStatById(String statId);
}
