package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.TeamStats;
import caplcom.codingAge.capl.Models.request.CreateRequests.TeamStatsRequest;
import caplcom.codingAge.capl.Repositories.TeamStatsRepo;
import caplcom.codingAge.capl.Services.TeamStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public TeamStats getTeamStatsByTeamId(String teamId) {
        return teamStatsRepo.findByTeamId(teamId);
    }
    @Override
    public TeamStats createMatchTeamStats(TeamStatsRequest teamStatsRequest) {
        TeamStats teamStats=new TeamStats();
         teamStats.setTeamId(teamStatsRequest.getTeamId());
         return teamStatsRepo.save(teamStats);
    }

    @Override
    // same here
    public TeamStats editMatchTeamStats(String teamId) {
        // what are you trying to do here...
        TeamStats teamStats=findByTeamId(teamId);
        if (teamStats!=null){
            if (teamId ==teamStats.getTeamId()){
                return teamStats;
            }
        }
        return new TeamStats();
    }

    private TeamStats findByTeamId(String teamId) {
        return teamStatsRepo.findByTeamId(teamId);
    }

}
