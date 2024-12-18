package caplcom.codingAge.capl.Services;


import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.request.CreateRequests.AddPlayerRequest;
import caplcom.codingAge.capl.Models.request.CreateRequests.TeamRequest;
import caplcom.codingAge.capl.Models.request.DeleteRequest.RemovePlayerRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateTeamRequest;

import java.util.List;

public interface TeamService {
    Team createTeam(TeamRequest teamRequest);

    Team getTeamById(String teamId);

    List<Team> getTeamByCreatorId(String creatorId);

    Team updateTeamDetails(UpdateTeamRequest updateTeamRequest);

    boolean removeTeamByTeamId(String teamId, String teamCreatorId);

    List<Player> getListOfPlayers(String teamId);

    boolean addPlayerInTeam(AddPlayerRequest addPlayerRequest);

    List<Team> getListOfTeam();

    boolean removePlayerFromTeam(RemovePlayerRequest removePlayerRequest);

    Player getPlayerByJerseyNumber(Integer newBowlerJerseyNumber, String teamId);

    Team saveUpdates(Team team);

    List<Player> getListOfPlayerByRoleFromTeam(String teamId, String playerRole);
}
