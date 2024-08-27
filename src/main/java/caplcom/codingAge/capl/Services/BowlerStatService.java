package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.BowlerStat;

public interface BowlerStatService {
    BowlerStat createInningBowlerStats(String scoreBoardId, String teamId, String playerId);
    BowlerStat getBowlerStatById(String bowlerId);
    BowlerStat getBowlerStatByPlayerId(String playerId);
    boolean addExtraRunInBowlerStats(Integer extraRun, String bowlerId);

    boolean addRunInBowler(String bowlerId, Integer run);
}
