package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.Tournament;
import caplcom.codingAge.capl.Models.request.CreateRequests.TournamentRequest;

import java.util.List;

public interface TournamentService {

    Tournament createTournament(TournamentRequest tournamentRequest);

    Tournament findByTournamentId(String tournamentId);


    Tournament addTeamsInTournament(String tournamentId, String teamId);

    boolean removeTeamFromTournament(String tournamentId, String teamId);


    //    List<MatchResult> getAllMatchesByTournamentId(String tournamentId);
    List<Team> getListOfTeamsOfTournament(String tournamentId);

}