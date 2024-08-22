package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.Season;
import caplcom.codingAge.capl.Models.Tournament;
import caplcom.codingAge.capl.Repositories.SeasonRepository;
import caplcom.codingAge.capl.Services.SeasonService;
import caplcom.codingAge.capl.Services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeasonServiceImpl implements SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;


//    @Override
//    public Season updateSeasonBySeasonYear(String seasonYear, String tournamentId) {
//        Season season = seasonRepository.findBySeasonYear(seasonYear);
//        Tournament tournament =  tournamentService.findByTournamentId(tournamentId);
//        if (tournament != null && season != null)  {
//            return new Season();
//            } else {
//                return new Season();
//        }
//    }


    @Override
    // is there need of this thing...
    public Season getSeasonDetailByTournamentId(String tournamentId, String seasonYear) {
        return null;
    }

    @Override
    public Season createSeason(String seasonYear) {
        Season season = new Season();
        season.setSeasonYear(seasonYear);
        return seasonRepository.save(season);
    }

    @Override
    public Season getSeasonBySeasonYear(String seasonYear) {
        Season season = seasonRepository.findBySeasonYear(seasonYear);
        if (season != null) {
            return season;
        }
        return new Season();
    }
}
