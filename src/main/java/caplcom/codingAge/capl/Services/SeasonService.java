package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Match;
import caplcom.codingAge.capl.Models.Season;
import caplcom.codingAge.capl.Models.Tournament;

import java.util.List;
import java.util.Optional;

public interface SeasonService {
//    Season updateSeasonBySeasonYear(String seasonYear, String tournamentId);


    Season createSeason(String seasonYear);

    Season getSeasonBySeasonYear(String seasonYear);

    Season addMatchInSeason(Match match);
    Season addTournamentInSeason(Tournament tournament);

    List<Season> getListOfSeason();

    List<Tournament> getListOfTournamentBySeasonYear(String seasonYear);

    void saveUpdates(Season seasonBySeasonYear);
}
