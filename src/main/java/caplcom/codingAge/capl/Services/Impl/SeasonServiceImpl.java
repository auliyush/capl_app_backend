package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.Match;
import caplcom.codingAge.capl.Models.Season;
import caplcom.codingAge.capl.Models.Tournament;
import caplcom.codingAge.capl.Repositories.SeasonRepository;
import caplcom.codingAge.capl.Services.SeasonService;
import caplcom.codingAge.capl.Services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class SeasonServiceImpl implements SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    @Override
    public Season createSeason(String seasonYear) {
        Season existingSeason = seasonRepository.findBySeasonYear(seasonYear);
        if (existingSeason !=null) {
            return existingSeason;
        }
        Season season = new Season();
        season.setSeasonYear(seasonYear);
        return seasonRepository.save(season);
    }

    @Override
    public Season getSeasonBySeasonYear(String seasonYear) {
        return Optional.ofNullable(seasonRepository.findBySeasonYear(seasonYear)).get();
    }

    @Override
    public Season addMatchInSeason(Match match) {
        int currentYear = Year.now().getValue();
        Season season = createSeason(String.valueOf(currentYear));
        season.getMatchList().add(match);
        return seasonRepository.save(season);
    }

    @Override
    public Season addTournamentInSeason(Tournament tournament) {
        int currentYear = Year.now().getValue();
        Season season = createSeason(String.valueOf(currentYear));
        season.getTournamentList().add(tournament);
        return seasonRepository.save(season);
    }

    @Override
    public List<Season> getListOfSeason() {
        return seasonRepository.findAll();
    }

    @Override
    public List<Tournament> getListOfTournamentBySeasonYear(String seasonYear) {
        Season existingSeason = seasonRepository.findBySeasonYear(seasonYear);
        if (existingSeason !=null) {
            return existingSeason.getTournamentList();
        }
        return List.of();
    }

    @Override
    public void saveUpdates(Season season) {
        seasonRepository.save(season);
    }
}
