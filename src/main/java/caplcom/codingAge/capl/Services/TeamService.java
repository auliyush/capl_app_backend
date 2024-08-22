package caplcom.codingAge.capl.Services;


import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateTeamRequest;

import java.util.List;

public interface TeamService {
//    Team createTeam(TeamRequest teamRequest);

    Team getTeamById(String teamId);

    Team getTeamByCreatorId(String creatorId);

    Team updateTeamDetails(UpdateTeamRequest updateTeamRequest);

    List<Player> getListOfPlayers(String teamId);

    boolean addPlayerInTeam(String teamId, String playerId);

    List<Team> getListOfTeam();

    boolean removePlayerFromTeam(String teamId, String playerId);
    Team saveUpdates(Team team);
}
