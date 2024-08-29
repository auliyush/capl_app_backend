package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.Season;
import caplcom.codingAge.capl.Models.Tournament;
import caplcom.codingAge.capl.Services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/season/details")
@CrossOrigin(origins = "*")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @GetMapping("/season/details/by/seasonYear")
    public Season getSeasonDetailBySeasonYear(@RequestParam String seasonYear) {
        return seasonService.getSeasonBySeasonYear(seasonYear);
    }

    @GetMapping("/season/ListOf/TournamentBy/seasonYear")
    public List<Tournament> getListOfTournamentBySeasonYear(@RequestParam String seasonYear) {
        return seasonService.getListOfTournamentBySeasonYear(seasonYear);
    }
    @GetMapping("/season/ListOf/season/seasonId")
    public  List<Season> getListOfSeason()
    {
        return seasonService.getListOfSeason();
    }
}
