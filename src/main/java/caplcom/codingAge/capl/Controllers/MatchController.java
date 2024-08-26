package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.Match;
import caplcom.codingAge.capl.Models.request.CreateRequests.MatchRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateMatchRequest;
import caplcom.codingAge.capl.Services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capl/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/create/match")
    public Match createMatch(@RequestBody MatchRequest matchRequest){
        return matchService.createMatch(matchRequest);
    }
    @PutMapping("/edit/matchDetail")
    public Match editMatchDetails(@RequestBody UpdateMatchRequest updateMatchRequest){
        return matchService.editMatchDetails(updateMatchRequest);
    }
//    @GetMapping("/matches/by/TeamId")
//    public List<Match> getMatchesByTeamId(@RequestParam String teamId){
//        return matchService.getMatchesByTeamId(teamId);
//    }
    @PutMapping("/update/match")
    public Match updateMatch(@RequestParam String matchId){
        return matchService.updateMatch(matchId);
    }
}
// not proper please check
// this is checked 25/08/2024