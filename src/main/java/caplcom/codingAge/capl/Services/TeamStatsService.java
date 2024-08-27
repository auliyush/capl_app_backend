package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.TeamStats;
import caplcom.codingAge.capl.Models.request.CreateRequests.TeamStatsRequest;

public interface TeamStatsService {
    TeamStats createMatchTeamStats(TeamStatsRequest teamStatsRequest);
    TeamStats getTeamStatsById(String Id);
    TeamStats getTeamStatsByTeamId(String teamId,String tournamentId);

    TeamStats addWinMatchByTeamIdAndTournamentId(String teamId,String tournamentId);
    TeamStats addLooseMatchByTeamIdAndTournamentId(String teamId,String tournamentId);
    TeamStats addDrawMatchByTeamIdAndTournamentId(String teamId, String tournamentId);
}
