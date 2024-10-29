package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.*;

import caplcom.codingAge.capl.Models.request.CreateRequests.AddTeamRequest;
import caplcom.codingAge.capl.Models.request.CreateRequests.TeamStatsRequest;
import caplcom.codingAge.capl.Models.request.CreateRequests.TournamentRequest;
import caplcom.codingAge.capl.Models.request.DeleteRequest.RemoveTeamRequest;
import caplcom.codingAge.capl.Repositories.TournamentRepository;
import caplcom.codingAge.capl.Services.*;
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
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamStatsService teamStatsService;


    @Override
    public Tournament createTournament(TournamentRequest tournamentRequest) {


        AdminUser adminUser = adminUserService.getAdminUserById(tournamentRequest.getCreatorId());

        if (adminUser == null) {
            return new Tournament();
        } else {
            Tournament tournament = new Tournament();
            tournament.setTournamentName(tournamentRequest.getTournamentName());
            tournament.setTournamentStartDate(tournamentRequest.getTournamentStartDate());
            tournament.setTournamentEndDate(tournamentRequest.getTournamentEndDate());
            tournament.setSeasonYear(tournamentRequest.getSeasonYear());
            tournament.setStadiumName(tournamentRequest.getStadiumName());
            tournament.setStadiumAddress(tournamentRequest.getStadiumAddress());
            tournament.setTournamentCreatorId(tournamentRequest.getCreatorId());
            seasonService.addTournamentInSeason(tournament);
            return tournamentRepository.save(tournament);
        }
    }

    @Override
    public Tournament findByTournamentId(String tournamentId) {
        return tournamentRepository.findByTournamentId(tournamentId);
    }

    @Override
    public boolean addTeamsInTournament(AddTeamRequest addTeamRequest) {
        Tournament tournament = findByTournamentId(addTeamRequest.getTournamentId());
        if (tournament != null) {
            if (tournament.getTournamentCreatorId().equals(addTeamRequest.getTournamentCreatorId())) {
                for (String teamId : addTeamRequest.getTeamsId()) {
                    Team team = teamService.getTeamById(teamId);
                    if (team != null) {
                        tournament.getTeamList().add(team);
                        team.setInTournament(true);
                        teamService.saveUpdates(team);
                        tournamentRepository.save(tournament);
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean removeTeamFromTournament(RemoveTeamRequest removeTeamRequest) {
        Tournament tournament = findByTournamentId(removeTeamRequest.getTournamentId());
        if (tournament != null) {
            if (tournament.getTournamentCreatorId().equals(removeTeamRequest.getTournamentCreatorId())) {
                for (String teamId : removeTeamRequest.getTeamsId()) {
                    Team team = teamService.getTeamById(teamId);
                    if (team != null) {
                        tournament.getTeamList().remove(team);
                        team.setInTournament(false);
                        teamService.saveUpdates(team);
                        tournamentRepository.save(tournament);
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public List<Team> getListOfTeamsOfTournament(String tournamentId) {
        Tournament tournament = findByTournamentId(tournamentId);
        if (tournament != null) {
            return tournament.getTeamList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Tournament> getListOfTournament() {
        return tournamentRepository.findAll();
    }
}