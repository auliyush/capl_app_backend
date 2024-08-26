package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.BatterStat;
import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Repositories.BatterStatRepository;
import caplcom.codingAge.capl.Services.BatterStatService;
import caplcom.codingAge.capl.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatterStatServiceImpl implements BatterStatService {
    @Autowired
    private BatterStatRepository batterStatRepository;
    @Autowired
    private PlayerService playerService;

    @Override
    public BatterStat createInningBatterStats(String scoreBoardId, String teamId, String playerId) {
        Player player = playerService.getPlayerById(playerId);
        if (player != null){
            BatterStat stats = new BatterStat();
            stats.setScoreBoardId(scoreBoardId);
            stats.setTeamId(teamId);
            stats.setPlayerId(playerId);
            return batterStatRepository.save(stats);
        }
        else{
            return null;
        }
    }
    @Override
    public BatterStat getBatterStatByPlayerId(String playerId, String scoreBoardId) {
        List<BatterStat> batterStatList = batterStatRepository.findAllByScoreBoardId(scoreBoardId);
        for (BatterStat batterStat : batterStatList){
            if(batterStat.getPlayerId().equals(playerId)){
                return batterStat;
            }
        }
        return null;
    }

    @Override
    public boolean addRunInStriker(String strikerId, int run) {
        BatterStat batterStat = getStatById(strikerId);
        batterStat.setTotalRuns(batterStat.getTotalRuns() + run);
        if(run == 4){
            batterStat.setTotalFours(batterStat.getTotalFours() + 1);
        } else if (run == 6) {
            batterStat.setTotalSix(batterStat.getTotalSix() + 1);
        }
        saveUpdates(batterStat);
        return true;
    }

    public BatterStat getStatById(String statId) {
        return batterStatRepository.findByStatId(statId);
    }

    @Override
    public BatterStat saveUpdates(BatterStat batterStat) {
        return batterStatRepository.save(batterStat);
    }
}
