package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.ScoreBoard;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateBatter;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateBowler;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateScoreBoardRequest;
import caplcom.codingAge.capl.Services.ScoreBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capl/scoreboard")
@CrossOrigin(origins = "*")
public class ScoreBoardController {
    // need api to calculate extras of each team...

    @Autowired
    private ScoreBoardService scoreBoardService;

    //don't need create api for user
//    @PostMapping("/create/scoreboard")
//    public ScoreBoard createScoreBoard (@RequestBody ScoreBoardRequest scoreBoardRequest){
//        return scoreBoardService.createScoreBoard (scoreBoardRequest);
//    }
    @PostMapping("/create")
    public ScoreBoard createScoreBoard(String matchId, String teamId) {
        return scoreBoardService.createScoreBoard(matchId, teamId);
    }

    @GetMapping("/get/scoreboardById")
    public ScoreBoard getScoreBoardById(@RequestParam String scoreBoardId) {
        return scoreBoardService.getScoreBoardById(scoreBoardId);
    }

    @GetMapping("/get/scoreboardTeamById")
    public ScoreBoard getScoreBoardByMatchAndTeamId(@RequestParam String teamId, String matchId) {
        return scoreBoardService.getScoreBoardByMatchAndTeamId(teamId, matchId);
    }

    @PutMapping("/update/scoreboard")
    public ScoreBoard updateScoreBoard(@RequestBody UpdateScoreBoardRequest updateScoreBoardRequest) {
        return scoreBoardService.updateScoreBoard(updateScoreBoardRequest);
    }

    @PutMapping("/change/bowler")
    public ScoreBoard changeBowler(@RequestBody UpdateBowler updateBowler) {
        return scoreBoardService.updateBowler(updateBowler);
    }

    //**
    // todo implement an api for change new batter
    @PutMapping("/change/batter")
    public ScoreBoard changeBatter(@RequestBody UpdateBatter updateBatter) {
        return scoreBoardService.updateBatter(updateBatter);
    }

    //**
    @GetMapping("/list/scoreboard")
    List<ScoreBoard> getListOfScoreBoard() {
        return scoreBoardService.getListOfScoreBoard();
    }
}
