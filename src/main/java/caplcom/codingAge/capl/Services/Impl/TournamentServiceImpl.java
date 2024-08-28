package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.AdminUser;

import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.TeamStats;
import caplcom.codingAge.capl.Models.Tournament;
import caplcom.codingAge.capl.Models.request.CreateRequests.TeamStatsRequest;
import caplcom.codingAge.capl.Models.request.CreateRequests.TournamentRequest;
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
            tournament.setCreatorId(tournamentRequest.getCreatorId());
            Tournament tournament1 = tournamentRepository.save(tournament);
            seasonService.addTournamentInSeason(tournament1);
            return tournament1;
        }
    }

    @Override
    public Tournament findByTournamentId(String tournamentId) {
        return tournamentRepository.findByTournamentId(tournamentId);
    }


    @Override
    public Tournament addTeamsInTournament(String tournamentId, String teamId) {
        Tournament tournament = findByTournamentId(tournamentId);

        if (tournament != null) {
            Team team = teamService.getTeamById(teamId);
            Team team1 = null;
            for (Team team2 : tournament.getTeamList()) {
                if (teamId.equals(team2.getTeamId())) {
                    team1 = team2;
                    break;
                }
            }

            if (team != null && team1 == null) {
                TeamStatsRequest teamStatsRequest = new TeamStatsRequest(teamId,tournamentId);
                TeamStats teamStats = teamStatsService.createMatchTeamStats(teamStatsRequest);
                tournament.getTeamStatsList().add(teamStats);
                tournament.getTeamList().add(team);
                return tournamentRepository.save(tournament);
            }
        }
        return new Tournament();
    }

    @Override
    public boolean removeTeamFromTournament(String tournamentId, String teamId) {
        Tournament tournament = findByTournamentId(tournamentId);
        if (tournament != null) {
            List<Team> teamList = tournament.getTeamList();
            for (int i = 0; i < teamList.size(); i++) {
                Team team = teamList.get(i);
                if (team.getTeamId().equals(teamId)) {
                    List<TeamStats> teamStats = tournament.getTeamStatsList();
                    teamList.remove(team);
                    teamStats.remove(teamStats.get(i));
                    tournament.setTeamList(teamList);
                    tournament.setTeamStatsList(teamStats);
                    tournamentRepository.save(tournament);
                    return true;
                }
            }
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

}