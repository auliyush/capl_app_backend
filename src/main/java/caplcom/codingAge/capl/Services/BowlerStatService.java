package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.BowlerStat;

public interface BowlerStatService {
    BowlerStat createInningBowlerStats(String matchId, String teamId, String playerId);

    boolean addExtraRunInBowlerStats(Integer extraRun, BowlerStat bowler);
}
