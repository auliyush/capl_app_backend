package caplcom.codingAge.capl.Services.Impl;


import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.request.CreateRequests.AddPlayerRequest;
import caplcom.codingAge.capl.Models.request.CreateRequests.TeamRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateTeamRequest;
import caplcom.codingAge.capl.Repositories.TeamRepository;
import caplcom.codingAge.capl.Services.AdminUserService;
import caplcom.codingAge.capl.Services.PlayerService;
import caplcom.codingAge.capl.Services.TeamService;
import caplcom.codingAge.capl.Services.UserService;
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
        if(adminUserService.getAdminUserByUserId(teamRequest.getTeamCreatorId()) != null){
            Team team = new Team();
            team.setTeamCreatorId(teamRequest.getTeamCreatorId());
            team.setTeamName(teamRequest.getTeamName());
            team.setTeamNickName(teamRequest.getTeamNickName());
            team.setTeamProfilePhotoUrl(teamRequest.getTeamProfilePhotoUrl());
            return teamRepository.save(team);
        }
        return null;
    }

    @Override
    public Team getTeamById(String teamId) {
        return teamRepository.findByTeamId(teamId);
    }

    @Override
    public Team getTeamByCreatorId(String creatorId) {
        return teamRepository.findByTeamCreatorId(creatorId);
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
            Player player = playerService.getPlayerById(addPlayerRequest.getPlayerId());
            if(player != null){
                if (team.getPlayerList() == null) {
                    team.setPlayerList(new ArrayList<>());
                }
                player.setJerseyNumber(addPlayerRequest.getJerseyNumber());
                team.getPlayerList().add(player);
                teamRepository.save(team);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removePlayerFromTeam(String teamId, String playerId, String creatorId) {
        Team team = getTeamById(teamId);
        if(team != null && team.getTeamCreatorId().equals(creatorId)){
            List<Player> playerList = getListOfPlayers(teamId);
            for(Player player : playerList){
                if(player.getPlayerId().equals(playerId)){
                   playerList.remove(player);
                   team.setPlayerList(playerList);
                   saveUpdates(team);
                    return true;
                }
                // why player not remove this api will not work properly
            }
        }
        return false;
    }

    @Override
    public List<Team> getListOfTeam() {
        return teamRepository.findAll();
    }

    @Override
    public Team saveUpdates(Team team) {
        return teamRepository.save(team);
    }
}
