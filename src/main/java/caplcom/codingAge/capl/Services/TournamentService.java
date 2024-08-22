package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Tournament;
import caplcom.codingAge.capl.Models.request.CreateRequests.TournamentRequest;

public interface TournamentService {

    Tournament createTournament(TournamentRequest tournamentRequest);

    Tournament findByTournamentId(String tournamentId);

    Tournament findBySeasonYear(String tournamentSeasonYear);

    Tournament addTeamsInTournament(String tournamentId , String teamId);

    boolean removeTeamFromTournament(String tournamentId, String teamId);



//    List<MatchResult> getAllMatchesByTournamentId(String tournamentId);

}