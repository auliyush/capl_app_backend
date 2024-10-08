package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.BowlerStat;
import caplcom.codingAge.capl.Models.Wicket;

public interface BowlerStatService {
    BowlerStat createInningBowlerStats(String scoreBoardId, String teamId, String playerId);

    BowlerStat getBowlerStatById(String bowlerId);

    BowlerStat getBowlerStatByPlayerId(String scoreBoardId, String playerId);

    boolean addExtraRunInBowlerStats(Integer extraRun, String bowlerId);

    BowlerStat addRunInBowler(String bowlerId, Integer run);

    BowlerStat addWicketInBowlerStat(Wicket wicket);
}
