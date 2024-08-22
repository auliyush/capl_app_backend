package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.Season;
import caplcom.codingAge.capl.Services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/v1/season/details")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    //

    public Season createSeason(@RequestParam String seasonYear) {
        return seasonService.createSeason(seasonYear);
    }

//    @PutMapping("/update/season/details")
//    public Season updateSeasonDetailBySeasonYear (@RequestParam String seasonYear, String tournamentId) {
//        return seasonService.updateSeasonBySeasonYear(seasonYear, tournamentId);
//    }

    @GetMapping("/season/detail/by/tournament")
    public Season getSeasonDetailByTournamentId (@RequestParam String tournamentId, String seasonYear) {
        return seasonService.getSeasonDetailByTournamentId(tournamentId,seasonYear);
    }

    @GetMapping("/season/details/by/seasonId")
    public Season getSeasonDetailBySeasonYear(@RequestParam String seasonYear) {
        return seasonService.getSeasonBySeasonYear(seasonYear);
    }
}
