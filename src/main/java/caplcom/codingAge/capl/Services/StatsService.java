//package caplcom.codingAge.capl.Services;
//
//import caplcom.codingAge.capl.Models.Stats;
//import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateStats;
//
//import java.util.List;
//
//public interface StatsService {
//    Stats createInningBatterStats(String matchId, String teamId, String playerId);
//    Stats createInningBowlerStats(String matchId, String teamId, String playerId);
//
//    Stats getStatsById(String statsId);
//
//    Stats updateStats(UpdateStats updateStats);
//
//    List<Stats> getAll();
//
//    boolean addPlayersRunInStat(String playerId, String matchId);
//
//    boolean addRunInBowlerStats(Integer extraRun);
//}