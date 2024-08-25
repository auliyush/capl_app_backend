package caplcom.codingAge.capl.Controllers;


import caplcom.codingAge.capl.Models.MatchResult;
import caplcom.codingAge.capl.Models.request.CreateRequests.MatchResultRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateMatchResult;
import caplcom.codingAge.capl.Services.MatchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capl/matchResult")
@CrossOrigin(origins = "*")
public class MatchResultController {
    @Autowired
    MatchResultService matchResultService;


    @GetMapping("/byMatchId")
    MatchResult getMatchResultByMatchId(String matchId) {
        return matchResultService.getMatchResultByMatchId(matchId);
    }

    @GetMapping("/lists")
    List<MatchResult> getMatchResultByTeamId(String teamId) {
        return matchResultService.getMatchByTeamId(teamId);
    }

    @PutMapping("/update")
    MatchResult editMatchResult(UpdateMatchResult updateMatchResult) {
        return matchResultService.updateMatchResult(updateMatchResult);
    }
}
