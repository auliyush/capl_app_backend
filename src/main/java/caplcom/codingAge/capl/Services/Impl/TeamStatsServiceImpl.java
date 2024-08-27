package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.TeamStats;
import caplcom.codingAge.capl.Models.request.CreateRequests.TeamStatsRequest;
import caplcom.codingAge.capl.Repositories.TeamStatsRepo;
import caplcom.codingAge.capl.Services.TeamStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamStatsServiceImpl implements TeamStatsService {
    @Autowired
    TeamStatsRepo teamStatsRepo;

    @Override
    public TeamStats getTeamStatsById(String id) {
        return teamStatsRepo.findById(id).orElse(null);
    }

    @Override
    // variable naming convention
    public TeamStats getTeamStatsByTeamId(String teamId,String tournamentId) {
        List<TeamStats> teamStatsList=teamStatsRepo.findAllByTournamentId(tournamentId);
        TeamStats teamStats = null;
        for ( TeamStats teamStats1:teamStatsList)
        {
            if(teamStats1.getTeamId().equals(teamId))
            {
                teamStats=teamStats1;
            }
        }
        return teamStats;
    }
    @Override
    public TeamStats createMatchTeamStats(TeamStatsRequest teamStatsRequest) {
        List<TeamStats> teamStatsList=teamStatsRepo.findAllByTournamentId(teamStatsRequest.getTournamentId());
        TeamStats teamStats = null;
        for ( TeamStats teamStats1:teamStatsList)
        {
            if(teamStats1.getTeamId().equals(teamStatsRequest.getTeamId()))
            {
                teamStats=teamStats1;
            }
        }
        if(teamStats==null)
        {
            teamStats=new TeamStats();
            teamStats.setTeamId(teamStatsRequest.getTeamId());
            return teamStatsRepo.save(teamStats);
        }
        return new TeamStats();
    }



    @Override
    public TeamStats addWinMatchByTeamIdAndTournamentId(String teamId,String tournamentId) {
        TeamStatsRequest teamStatsRequest=new TeamStatsRequest(teamId,tournamentId);
        TeamStats teamStats=createMatchTeamStats(teamStatsRequest);
        teamStats.setMatchWinning(teamStats.getMatchWinning()+1);
        return teamStats;
    }

    @Override
    public TeamStats addLooseMatchByTeamIdAndTournamentId(String teamId, String tournamentId) {
        TeamStatsRequest teamStatsRequest=new TeamStatsRequest(teamId,tournamentId);
        TeamStats teamStats=createMatchTeamStats(teamStatsRequest);
        teamStats.setMatchLosing(teamStats.getMatchLosing()+1);
        return teamStats;

    }

    @Override
    public TeamStats addDrawMatchByTeamIdAndTournamentId(String teamId, String tournamentId) {
        TeamStatsRequest teamStatsRequest=new TeamStatsRequest(teamId,tournamentId);
        TeamStats teamStats=createMatchTeamStats(teamStatsRequest);
        teamStats.setMatchDrawn(teamStats.getMatchWinning()+1);
        return teamStats;
    }



}
