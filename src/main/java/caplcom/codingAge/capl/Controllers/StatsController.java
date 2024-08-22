package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.Stats;
import caplcom.codingAge.capl.Models.request.CreateRequests.StatsRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateStats;
import caplcom.codingAge.capl.Services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stats")
public class StatsController {

    @Autowired

    private StatsService statsService;

    @PostMapping("/createStas")
    public Stats createStats(@RequestBody StatsRequest statsRequest){
        return statsService.createStats(statsRequest);
    }

    @GetMapping("/getStatsById")
    public Stats getStatsById(@RequestParam String statsId){
        return statsService.getStatsById(statsId);
    }

    @PutMapping("/updateStats")
    public Stats updateStats(@RequestBody UpdateStats updateStats){
        return statsService.updateStats(updateStats);
    }

    @GetMapping("/getAllStats")
    public List<Stats> getAll(){
        return statsService.getAll();
    }


}