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
    MatchResult getMatchById(String matchId) {
        return matchResultService.getMatchById(matchId);
    }

    @GetMapping("/lists")
    List<MatchResult> getMatchByTeamId(String teamId) {
        return matchResultService.getMatchByTeamId(teamId);
    }

    @PostMapping("/create")
    MatchResult createMatchResult(MatchResultRequest matchResultRequest) {
        return matchResultService.createMatchResult(matchResultRequest);
    }

    @PutMapping("/update")
    MatchResult editMatchResult(UpdateMatchResult updateMatchResult) {
        return matchResultService.editMatchResult(updateMatchResult);
    }
}
