package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.Tournament;
import caplcom.codingAge.capl.Models.request.CreateRequests.AddTeamRequest;
import caplcom.codingAge.capl.Models.request.CreateRequests.TournamentRequest;
import caplcom.codingAge.capl.Models.request.DeleteRequest.RemoveTeamRequest;

import java.util.List;

public interface TournamentService {

    Tournament createTournament(TournamentRequest tournamentRequest);

    Tournament findByTournamentId(String tournamentId);


    boolean addTeamsInTournament(AddTeamRequest addTeamRequest);

    boolean removeTeamFromTournament(RemoveTeamRequest removeTeamRequest);

    //    List<MatchResult> getAllMatchesByTournamentId(String tournamentId);
    List<Team> getListOfTeamsOfTournament(String tournamentId);

    List<Tournament> getListOfTournament();
}