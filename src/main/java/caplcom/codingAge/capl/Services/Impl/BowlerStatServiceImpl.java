package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.BatterStat;
import caplcom.codingAge.capl.Models.BowlerStat;
import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.Wicket;
import caplcom.codingAge.capl.Repositories.BowlerStatRepository;
import caplcom.codingAge.capl.Services.BowlerStatService;
import caplcom.codingAge.capl.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BowlerStatServiceImpl implements BowlerStatService {
    @Autowired
    private BowlerStatRepository bowlerStatRepository;
    @Autowired
    private PlayerService playerService;

    @Override
    public BowlerStat createInningBowlerStats(String scoreBoardId, String teamId, String playerId) {
        Player player = playerService.getPlayerById(playerId);
        if (player != null) {
            BowlerStat stats = new BowlerStat();
            stats.setScoreBoardId(scoreBoardId);
            stats.setTeamId(teamId);
            stats.setPlayerId(playerId);
            return bowlerStatRepository.save(stats);
        } else {
            return null;
        }
    }

    @Override
    public boolean addExtraRunInBowlerStats(Integer extraRun, String bowlerId) {
        BowlerStat bowlerStat = getBowlerStatById(bowlerId);
        bowlerStat.setTotalRuns(bowlerStat.getTotalRuns() + extraRun);
        if (extraRun == 4) {
            bowlerStat.setTotalFours(bowlerStat.getTotalFours() + 1);
        } else if (extraRun == 6) {
            bowlerStat.setTotalSix(bowlerStat.getTotalSix() + 1);
        }
        bowlerStatRepository.save(bowlerStat);
        return true;
    }

    @Override
    public BowlerStat getBowlerStatById(String bowlerId) {
        return bowlerStatRepository.findByStatId(bowlerId);
    }

    @Override
    public BowlerStat getBowlerStatByPlayerId(String scoreBoardId, String playerId) {
        List<BowlerStat> bowlerStatList = bowlerStatRepository.findAllByScoreBoardId(scoreBoardId);
        for (BowlerStat bowlerStat : bowlerStatList){
            if(bowlerStat.getPlayerId().equals(playerId)){
                return bowlerStat;
            }
        }
        return null;
    }

    @Override
    public boolean addRunInBowler(String bowlerId, Integer run) {
        BowlerStat bowlerStat = getBowlerStatById(bowlerId);
        bowlerStat.setTotalRuns(bowlerStat.getTotalRuns() + run);
        if (run == 4) {
            bowlerStat.setTotalFours(bowlerStat.getTotalFours() + 1);
        } else if (run == 6) {
            bowlerStat.setTotalSix(bowlerStat.getTotalSix() + 1);
        }
        bowlerStatRepository.save(bowlerStat);
        return true;
    }

    @Override
    public BowlerStat addWicketInBowlerStat(Wicket wicket) {
        BowlerStat bowlerStat = getBowlerStatById(wicket.getBowlerId());
        bowlerStat.getWicketsList().add(wicket);
        return bowlerStatRepository.save(bowlerStat);
    }
}
