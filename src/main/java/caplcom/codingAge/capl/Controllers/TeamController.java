package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateTeamRequest;
import caplcom.codingAge.capl.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capl/team")
@CrossOrigin(origins = "*")
public class TeamController {

    @Autowired
    private TeamService teamService;

//    @PostMapping("/create/Team")
//    public Team createTeam(@RequestBody TeamRequest teamRequest){
//        return teamService.createTeam(teamRequest);
//    }

    @GetMapping("/getTeamById")
    public Team getTeamById(@RequestParam String teamId){
        return teamService.getTeamById(teamId);
    }

    @GetMapping("/getTeamBy/creatorId")
    public Team getTeamByCreatorId(@RequestParam String creatorId){
        return teamService.getTeamByCreatorId(creatorId);
    }

    @PutMapping("/update/team")
    public Team updateTeamDetails(@RequestBody UpdateTeamRequest updateTeamRequest){
        return teamService.updateTeamDetails(updateTeamRequest);
    }
    @GetMapping("/list/ofPlayers")
    public List<Player> getListOfPlayers(@RequestParam String teamId){
        return teamService.getListOfPlayers(teamId);
    }

    @PutMapping("/add/player")
    public boolean addPlayerInTeam(@RequestParam String teamId, String playerId){
        return teamService.addPlayerInTeam(teamId, playerId);
    }
    @PutMapping("/remove/player")
    public boolean removePlayerFromTeam(@RequestParam String teamId, String playerId){
     return teamService.removePlayerFromTeam(teamId, playerId);
    }
    @GetMapping("/listOf/Teams")
    public List<Team> getListOfTeam(){
        return teamService.getListOfTeam();
    }

}
