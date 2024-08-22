package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.Season;
import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.Tournament;
import caplcom.codingAge.capl.Models.request.CreateRequests.TournamentRequest;
import caplcom.codingAge.capl.Repositories.TournamentRepository;
import caplcom.codingAge.capl.Services.SeasonService;
import caplcom.codingAge.capl.Services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private SeasonService seasonService;

    @Override
    public Tournament createTournament(TournamentRequest tournamentRequest) {

        // extra things added
        Season season = seasonService.getSeasonBySeasonYear(tournamentRequest.getSeasonYear());

        if (season == null) {
            return new Tournament();
        } else {
            Tournament tournament = new Tournament();
            tournament.setTournamentName(tournamentRequest.getTournamentName());
            tournament.setTournamentStartDate(tournamentRequest.getTournamentStartDate());
            tournament.setTournamentEndDate(tournamentRequest.getTournamentEndDate());
            tournament.setSeasonYear(tournamentRequest.getSeasonYear());
            tournament.setStadiumName(tournamentRequest.getStadiumName());
            tournament.setStadiumAddress(tournamentRequest.getStadiumAddress());
            tournament.setCreatorId(tournamentRequest.getCreatorId());
            // adding here
            season.getTournamentList().add(tournament);
            // add season repo...
            return tournamentRepository.save(tournament);
        }
    }

    @Override
    public Tournament findByTournamentId(String tournamentId) {
        return tournamentRepository.findByTournamentId(tournamentId);
    }

    @Override
    public Tournament findBySeasonYear(String tournamentSeasonYear) {
        return tournamentRepository.findBySeasonYear(tournamentSeasonYear);
    }

    @Override
    public Tournament addTeamsInTournament(String tournamentId , String teamId) {
        Tournament tournament = findByTournamentId(tournamentId);

        if (tournament != null){
            TeamServiceImpl teamService = new TeamServiceImpl();
            Team team1 = teamService.getTeamById(teamId);
            if (team1 != null){
                Team team = teamService.getTeamById(teamId);
                tournament.getTeamList().add(team);
                return tournamentRepository.save(tournament);
            }
        }
        return new Tournament();
    }

    @Override
    public boolean removeTeamFromTournament(String tournamentId, String teamId) {
        Tournament tournament = findByTournamentId(tournamentId);
        if(tournament != null){
            for(Team team : getListOfTeamsOfTournament(tournamentId)){
                if(team.getTeamId().equals(teamId)){
                    getListOfTeamsOfTournament(teamId).remove(team);
                    tournamentRepository.save(tournament);
                    return true;
                }
            }
        }
        return false;
    }


    List<Team> getListOfTeamsOfTournament(String tournamentId){
        Tournament tournament = findByTournamentId(tournamentId);
        if (tournament != null){
            return tournament.getTeamList();
        }
        return new ArrayList<>();
    }

}