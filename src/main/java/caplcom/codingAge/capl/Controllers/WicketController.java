package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.Wicket;
import caplcom.codingAge.capl.Models.request.CreateRequests.WicketRequest;
import caplcom.codingAge.capl.Services.WicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wicket")
public class WicketController {

    @Autowired
   private WicketService wicketService;

    @PostMapping("/bold")
    public Wicket createWicket (@RequestBody WicketRequest wicketRequest) {
        return wicketService.createWicket(wicketRequest);
    }

    @GetMapping("/wicket/byId")
    public Wicket getWicketById (@RequestParam String wicketId) {
        return wicketService.getWicketById(wicketId);
    }

    @GetMapping("/wickets/by/bowler")
    public List<Wicket> getWicketsByBowlerId (@RequestParam String bowlerId) {
        return wicketService.getWicketsByBowlerId(bowlerId);
    }
    // why need this api
    @GetMapping("/wickets/by/batter")
    public List<Wicket> getWicketsByBatterId(@RequestParam String batterId) {
        return wicketService.getWicketsByBatterId(batterId);
    }

}
