package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.MatchResult;
import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.Tournament;
import caplcom.codingAge.capl.Models.request.CreateRequests.TournamentRequest;
import caplcom.codingAge.capl.Services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capl/tournament")
@CrossOrigin(origins = "*")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/create/tournament")
    public Tournament createTournament(@RequestBody TournamentRequest tournamentRequest) {
        return tournamentService.createTournament(tournamentRequest);
    }

    @GetMapping("/findByTournamentId")
    public Tournament findByTournamentId(@RequestParam String tournamentId) {
        return tournamentService.findByTournamentId(tournamentId);
    }

    @PutMapping("/addTeamsInTournament")
    public Tournament addTeamsInTournament(@RequestParam String tournamentId, String teamId) {
        return tournamentService.addTeamsInTournament(tournamentId, teamId);
    }

    @PutMapping("/removeTeamFromTournament")
    public boolean removeTeamFromTournament(@RequestParam String tournamentId, String teamId) {
        return tournamentService.removeTeamFromTournament(tournamentId, teamId);
    }

    //    public List<MatchResult> getAllMatchesByTournamentId(@RequestParam Integer tournamentId){
//        return tournamentService.getAllMatchesByTournamentId(tournamentId);
//    }
    @GetMapping("/getListOfTeam/ByTournamentId")
    public List<Team> getListOfTeamsOfTournament(@RequestParam  String tournamentId) {
        return tournamentService.getListOfTeamsOfTournament(tournamentId);
    }

}