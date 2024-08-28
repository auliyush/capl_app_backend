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

    //    you can use this API while creating a match and winning team choose batting or bowling
    @PostMapping("/create")
    public ScoreBoard createScoreBoard(String matchId, String teamId) {
        return scoreBoardService.createScoreBoard(matchId, teamId);
    }

    @GetMapping("/get/scoreboardById")
    public ScoreBoard getScoreBoardById(@RequestParam String scoreBoardId) {
        return scoreBoardService.getScoreBoardById(scoreBoardId);
    }

    //    this API use for getting scoreBoard by match Id and Team Id
    @GetMapping("/get/Match/scoreboard/ByTeamId")
    public ScoreBoard getScoreBoardByMatchAndTeamId(@RequestParam String teamId, String matchId) {
        return scoreBoardService.getScoreBoardByMatchAndTeamId(teamId, matchId);
    }

    //        you can use this API when you enter striker non-Striker bowler id then you tap start match
//    this api create striker non-striker bowler stats
    @PutMapping("/update/scoreboard")
    public ScoreBoard updateScoreBoard(@RequestBody UpdateScoreBoardRequest updateScoreBoardRequest) {
        return scoreBoardService.updateScoreBoard(updateScoreBoardRequest);
    }

    //    this API for changing bowler
    @PutMapping("/change/bowler")
    public ScoreBoard changeBowler(@RequestBody UpdateBowler updateBowler) {
        return scoreBoardService.updateBowler(updateBowler);
    }

    //    this API for changing batter
    @PutMapping("/change/batter")
    public ScoreBoard changeBatter(@RequestBody UpdateBatter updateBatter) {
        return scoreBoardService.updateBatter(updateBatter);
    }

    //this API for add run in ScoreBoard and also in stats Info
    @PutMapping("/add/runs")
    public ScoreBoard addRuns(@RequestBody String scoreBoardId, Integer run) {
        return scoreBoardService.addRuns(scoreBoardId, run);
    }

    @GetMapping("/list/scoreboard")
    List<ScoreBoard> getListOfScoreBoard() {
        return scoreBoardService.getListOfScoreBoard();
    }
}

//this is checked 28/08/2024  12:20