package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.BowlerStat;
import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Repositories.BowlerStatRepository;
import caplcom.codingAge.capl.Services.BowlerStatService;
import caplcom.codingAge.capl.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BowlerStatServiceImpl implements BowlerStatService {
    @Autowired
    private BowlerStatRepository bowlerStatRepository;
    @Autowired
    private PlayerService playerService;
    @Override
    public BowlerStat createInningBowlerStats(String matchId, String teamId, String playerId) {
        Player player = playerService.getPlayerById(playerId);
        if (player != null){
            BowlerStat stats = new BowlerStat();
            stats.setScoreBoardId(matchId);
            stats.setTeamId(teamId);
            stats.setPlayerId(playerId);
            return bowlerStatRepository.save(stats);
        }
        else{
            return null;
        }
    }

    @Override
    public boolean addExtraRunInBowlerStats(Integer extraRun, BowlerStat bowler) {
        bowler.setTotalRuns(extraRun);
        if(extraRun == 4){
            bowler.setTotalFours(bowler.getTotalFours() + 1);
        } else if (extraRun == 6) {
            bowler.setTotalSix(bowler.getTotalSix() + 1);
        }
    }
}
