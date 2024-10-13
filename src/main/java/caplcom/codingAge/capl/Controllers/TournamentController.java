package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.MatchResult;
import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.Tournament;
import caplcom.codingAge.capl.Models.request.CreateRequests.AddTeamRequest;
import caplcom.codingAge.capl.Models.request.CreateRequests.TournamentRequest;
import caplcom.codingAge.capl.Models.request.DeleteRequest.RemoveTeamRequest;
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

    @GetMapping("/find/By/TournamentId")
    public Tournament findByTournamentId(@RequestParam String tournamentId) {
        return tournamentService.findByTournamentId(tournamentId);
    }

    @PutMapping("/add/Teams/Tournament")
    public boolean addTeamsInTournament(@RequestBody AddTeamRequest addTeamRequest) {
        return tournamentService.addTeamsInTournament(addTeamRequest);
    }

    @PutMapping("/remove/Team/Tournament")
    public boolean removeTeamFromTournament(@RequestBody RemoveTeamRequest removeTeamRequest) {
        return tournamentService.removeTeamFromTournament(removeTeamRequest);
    }

    @GetMapping("/get/listOf/tournament")
    public List<Tournament> getListOfTournament(){
        return tournamentService.getListOfTournament();
    }
    //    public List<MatchResult> getAllMatchesByTournamentId(@RequestParam Integer tournamentId){
//        return tournamentService.getAllMatchesByTournamentId(tournamentId);
//    }
    @GetMapping("/getListOfTeam/ByTournamentId")
    public List<Team> getListOfTeamsOfTournament(@RequestParam  String tournamentId) {
        return tournamentService.getListOfTeamsOfTournament(tournamentId);
    }

}