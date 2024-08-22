package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.ScoreBoard;
import caplcom.codingAge.capl.Models.request.CreateRequests.ScoreBoardRequest;
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

    @PostMapping("/create/scoreboard")
    public ScoreBoard createScoreBoard (@RequestBody ScoreBoardRequest scoreBoardRequest){
        return scoreBoardService.createScoreBoard (scoreBoardRequest);
    }

    @GetMapping("/get/scoreboardById")
    public ScoreBoard getScoreBoardById (@RequestParam String scoreBoardId){
        return scoreBoardService.getScoreBoardById (scoreBoardId);
    }

    @GetMapping("/get/scoreboardTeamById")
    public ScoreBoard getScoreBoardByTeamId(@RequestParam String firstTeamId , String secondTeamId){
        return scoreBoardService.getScoreBoardByTeamId(firstTeamId,secondTeamId);
    }

    @PutMapping("/update/scoreboard")
    public ScoreBoard editScoreBoard (@RequestBody UpdateScoreBoardRequest updateScoreBoardRequest){
        return scoreBoardService.editScoreBoard (updateScoreBoardRequest);
    }

    @GetMapping("/list/scoreboard")
    List <ScoreBoard> getListOfScoreBoard () {
        return scoreBoardService.getListOfScoreBoard();
    }
}
