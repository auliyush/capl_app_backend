package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.Season;
import caplcom.codingAge.capl.Models.Tournament;
import caplcom.codingAge.capl.Services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/season")
@CrossOrigin(origins = "*")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @GetMapping("/details/by/seasonYear")
    public Season getSeasonDetailBySeasonYear(@RequestParam String seasonYear) {
        return seasonService.getSeasonBySeasonYear(seasonYear);
    }

    @GetMapping("/ListOf/TournamentBy/seasonYear")
    public List<Tournament> getListOfTournamentBySeasonYear(@RequestParam String seasonYear) {
        return seasonService.getListOfTournamentBySeasonYear(seasonYear);
    }
    @GetMapping("/ListOf/season/")
    public  List<Season> getListOfSeason()
    {
        return seasonService.getListOfSeason();
    }
}
