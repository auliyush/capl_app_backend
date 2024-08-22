package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Season;

public interface SeasonService {
//    Season updateSeasonBySeasonYear(String seasonYear, String tournamentId);

    Season getSeasonDetailByTournamentId(String tournamentId, String seasonYear);

    Season createSeason(String seasonYear);

    Season getSeasonBySeasonYear(String seasonYear);
}
