package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.BowlerStat;

public interface BowlerStatService {
    BowlerStat createInningBowlerStats(String matchId, String teamId, String playerId);
    BowlerStat getBowlerStatById(String bowlerId);
    boolean addExtraRunInBowlerStats(Integer extraRun, String bowlerId);

    boolean addRunInBowler(String bowlerId, Integer run);
}
