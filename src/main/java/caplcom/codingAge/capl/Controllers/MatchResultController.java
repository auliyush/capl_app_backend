package caplcom.codingAge.capl.Controllers;


import caplcom.codingAge.capl.Models.MatchResult;
import caplcom.codingAge.capl.Models.request.CreateRequests.MatchResultRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateMatchResult;
import caplcom.codingAge.capl.Services.MatchResultService;
import caplcom.codingAge.capl.Services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capl/matchResult")
@CrossOrigin(origins = "*")
public class MatchResultController {
    @Autowired
    private MatchResultService matchResultService;

    @PostMapping("/create")
    public MatchResult createMatchResult(@RequestBody MatchResultRequest matchResultRequest){
        return matchResultService.createMatchResult(matchResultRequest);
    }
    @GetMapping("/byMatchId")
    public MatchResult getMatchResultByMatchId(String matchId) {
        return matchResultService.getMatchResultByMatchId(matchId);
    }

    @GetMapping("/lists")
    public List<MatchResult> getMatchResultByTeamId(String teamId) {
        return matchResultService.getMatchResultByTeamId(teamId);
    }
}
// this is checked 28/08/2024  12:20
