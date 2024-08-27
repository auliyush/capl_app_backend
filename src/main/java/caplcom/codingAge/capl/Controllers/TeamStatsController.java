package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.TeamStats;
import caplcom.codingAge.capl.Models.request.CreateRequests.TeamStatsRequest;
import caplcom.codingAge.capl.Services.TeamStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/capl/teamstats")
public class TeamStatsController {
    @Autowired
    private TeamStatsService teamStatsService;

    @GetMapping("/getByStatsId")
    public TeamStats getTeamStatsById(@RequestParam String id) {
        return teamStatsService.getTeamStatsById(id);
    }

    @GetMapping("/getTeamStatsByTeamIdAndTournamentId")
    public TeamStats getTeamStatsByTeamIdAndTournamentId(@RequestParam String teamId, String tournamentId) {
        return teamStatsService.getTeamStatsByTeamId(teamId, tournamentId);
    }

    @PutMapping("/addWinMatchByTeamIdAndTournamentId")
    public TeamStats addWinMatchByTeamIdAndTournamentId(@RequestParam String teamId, String tournamentId) {
        return teamStatsService.addWinMatchByTeamIdAndTournamentId(teamId, tournamentId);
    }

    @PutMapping("/addLooseMatchByTeamIdAndTournamentId")
    public TeamStats addLooseMatchByTeamIdAndTournamentId(@RequestParam String teamId, String tournamentId) {
        return teamStatsService.addLooseMatchByTeamIdAndTournamentId(teamId, tournamentId);
    }

    @PutMapping("/addDrawMatchByTeamIdAndTournamentId")
    public TeamStats addDrawMatchByTeamIdAndTournamentId(@RequestParam String teamId, String tournamentId) {
        return teamStatsService.addDrawMatchByTeamIdAndTournamentId(teamId, tournamentId);
    }


}
