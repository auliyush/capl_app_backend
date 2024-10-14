package caplcom.codingAge.capl.Services.Impl;


import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.request.CreateRequests.AddPlayerRequest;
import caplcom.codingAge.capl.Models.request.CreateRequests.TeamRequest;
import caplcom.codingAge.capl.Models.request.DeleteRequest.RemovePlayerRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateTeamRequest;
import caplcom.codingAge.capl.Repositories.TeamRepository;
import caplcom.codingAge.capl.Services.AdminUserService;
import caplcom.codingAge.capl.Services.PlayerService;
import caplcom.codingAge.capl.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private AdminUserService adminUserService;
    public Team createTeam(TeamRequest teamRequest) {
        if(adminUserService.getAdminUserById(teamRequest.getTeamCreatorId()) != null){
            Team team = new Team();
            team.setTeamCreatorId(teamRequest.getTeamCreatorId());
            team.setTeamName(teamRequest.getTeamName());
            team.setTeamNickName(teamRequest.getTeamNickName());
            team.setTeamProfilePhotoUrl(teamRequest.getTeamProfilePhotoUrl());
            team.setActive(true);
            return teamRepository.save(team);
        }
        return null;
    }

    @Override
    public Team getTeamById(String teamId) {
        return teamRepository.findByTeamId(teamId);
    }

    @Override
    public List<Team> getTeamByCreatorId(String creatorId) {
        return teamRepository.findAllByTeamCreatorId(creatorId);
    }
    @Override
    public Team updateTeamDetails(UpdateTeamRequest updateTeamRequest) {
        Team team = getTeamById(updateTeamRequest.getTeamId());
        if(team != null){
            if(team.getTeamCreatorId().equals(updateTeamRequest.getCreatorId())){
                team.setTeamName(updateTeamRequest.getTeamName());
                team.setTeamNickName(updateTeamRequest.getTeamNickName());
                team.setTeamCoachName(updateTeamRequest.getTeamCoachName());
                team.setTeamCaptainId(updateTeamRequest.getTeamCaptainId());
                team.setTeamProfilePhotoUrl(updateTeamRequest.getTeamProfilePhotoUrl());
                return teamRepository.save(team);
            }
        }
        return null;
    }
    @Override
    public boolean removeTeamByTeamId(String teamId, String teamCreatorId) {
        Team team = teamRepository.findByTeamId(teamId);
        if(team == null) {
            return false;
        } else if (!team.getTeamCreatorId().equals(teamCreatorId)) {
            return  false;
        }
        else {
            for(Player player : team.getPlayerList()) {
                player.setInTeam(false);
                playerService.saveUpdates(player);
            }
            team.setActive(false);
            teamRepository.save(team);
            return true;
        }
    }
    @Override
    public List<Player> getListOfPlayers(String teamId) {
        if(getTeamById(teamId) != null){
            return getTeamById(teamId).getPlayerList();
        }
        return Collections.emptyList();
    }

    @Override
    public boolean addPlayerInTeam(AddPlayerRequest addPlayerRequest) {
        Team team = getTeamById(addPlayerRequest.getTeamId());
        if(team != null && team.getTeamCreatorId().equals(addPlayerRequest.getCreatorId())){
            for (String playerId : addPlayerRequest.getPlayers()){
                Player player = playerService.getPlayerById(playerId);
                if(player != null){
                    if (team.getPlayerList() == null) {
                        team.setPlayerList(new ArrayList<>());
                    }
                    team.getPlayerList().add(player);
                    player.setInTeam(true);
                    teamRepository.save(team);
                    playerService.saveUpdates(player);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean removePlayerFromTeam(RemovePlayerRequest removePlayerRequest) {
        Team team = getTeamById(removePlayerRequest.getTeamId());
        if(team != null && team.getTeamCreatorId().equals(removePlayerRequest.getCreatorId())){
            for (String playerId : removePlayerRequest.getPlayersId()){
                Player player = playerService.getPlayerById(playerId);
                if(player != null){
                    if (team.getPlayerList() == null) {
                        team.setPlayerList(new ArrayList<>());
                    }
                    team.getPlayerList().remove(player);
                    player.setInTeam(false);
                    teamRepository.save(team);
                    playerService.saveUpdates(player);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public Player getPlayerByJerseyNumber(Integer newBowlerJerseyNumber, String teamId) {
        List<Player> playerList = getListOfPlayers(teamId);
        for(Player player : playerList){
            if(player.getJerseyNumber().equals(newBowlerJerseyNumber)){
                return player;
            }
        }
        return null;
    }

    @Override
    public List<Team> getListOfTeam() {
        return teamRepository.findAllByIsActive(true);
    }

    @Override
    public List<Player> getListOfPlayerByRoleFromTeam(String teamId, String playerRole) {
        Team team = teamRepository.findByTeamId(teamId);
        if(team == null){
            return null;
        }
        List<Player> playerListByRole = new ArrayList<>();
        for (Player player : team.getPlayerList()){
            if(player.getPlayerType().equals(playerRole)){
                playerListByRole.add(player);
            }
        }
        return playerListByRole;
    }

    @Override
    public Team saveUpdates(Team team) {
        return teamRepository.save(team);
    }
}
