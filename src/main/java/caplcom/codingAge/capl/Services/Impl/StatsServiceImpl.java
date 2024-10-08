//package caplcom.codingAge.capl.Services.Impl;
//
//import caplcom.codingAge.capl.Models.Player;
//import caplcom.codingAge.capl.Models.Stats;
//import caplcom.codingAge.capl.Models.request.CreateRequests.StatsRequest;
//import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateStats;
//import caplcom.codingAge.capl.Repositories.StatsRepository;
//import caplcom.codingAge.capl.Services.PlayerService;
//import caplcom.codingAge.capl.Services.StatsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Service
//public class StatsServiceImpl implements StatsService {
//    @Autowired
//    private StatsRepository statsRepository;
//    @Autowired
//    private PlayerService playerService;
//
//    @Override
//    public Stats createInningBatterStats(String matchId, String teamId, String playerId) {
//        Player player = playerService.getPlayerById(playerId);
//        if (player != null){
//            Stats stats = new Stats();
//            stats.setMatchId(matchId);
//            stats.setTeamId(teamId);
//            stats.setPlayerId(playerId);
//            return statsRepository.save(stats);
//        }
//        else{
//            return null;
//        }
//    }
//
//    @Override
//    public Stats createInningBowlerStats(String matchId, String teamId, String playerId) {
//        return null;
//    }
//
//    @Override
//    public Stats getStatsById(String statsId) {
//        Stats stats = statsRepository.findByStatsId(statsId);
//        return Objects.requireNonNullElseGet(stats, Stats::new);
//
//    }
//
//    @Override
//    public Stats updateStats(UpdateStats updateStats) {
//        Optional<Stats> stats=statsRepository.findById(updateStats.getStatsId());
//        if (stats.isPresent()){
//            Stats stats1 = new Stats();
//            stats1.setMatchId(updateStats.getMatchId());
//            stats1.setTeamId(updateStats.getTeamId());
//            stats1.setPlayerId(updateStats.getPlayerId());
//            stats1.setTotalRuns(updateStats.getTotalRuns());
//            stats1.setStrikeRate(updateStats.getStrikeRate());
//            stats1.setEconomyRate(updateStats.getEconomyRate());
//            stats1.setTotalBalls(updateStats.getTotalBalls());
//            stats1.setTotalFours(updateStats.getTotalFours());
//            stats1.setTotalSix(updateStats.getTotalSix());
//            return statsRepository.save(stats1);
//        }
//        return new Stats();
//    }
//
//    @Override
//    public boolean addPlayersRunInStat(String playerId, String matchId) {
//        return false;
//    }
//
//    @Override
//    public boolean addRunInBowlerStats(Integer extraRun) {
//
//    }
//
//    @Override
//    public List<Stats> getAll() {
//        return statsRepository.findAll();
//    }
//
//}