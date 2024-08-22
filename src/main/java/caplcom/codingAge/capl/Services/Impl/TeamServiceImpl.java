package caplcom.codingAge.capl.Services.Impl;


import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.request.CreateRequests.TeamRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateTeamRequest;
import caplcom.codingAge.capl.Repositories.TeamRepository;
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
    private UserService userService;
    public Team createTeam(TeamRequest teamRequest) {
        if(userService.getUserByUserId(teamRequest.getTeamCreatorId()) != null){
            Team team = new Team();
            team.setTeamCreatorId(teamRequest.getTeamCreatorId());
            team.setTeamName(teamRequest.getTeamName());
            team.setTeamNickName(teamRequest.getTeamNickName());
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
    public boolean addPlayerInTeam(String teamId, String playerId) {
        Team team = getTeamById(teamId);
        if(team != null){
            Player player = playerService.getPlayerById(playerId);
            if(player != null){
                if (team.getPlayerList() == null) {
                    team.setPlayerList(new ArrayList<>());
                }
                team.getPlayerList().add(player);
                teamRepository.save(team);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removePlayerFromTeam(String teamId, String playerId) {
        Team team = getTeamById(teamId);
        if(team != null){
            for(Player player : getListOfPlayers(teamId)){
                if(player.getPlayerId().equals(playerId)){
                   getListOfPlayers(teamId).remove(player);
                   teamRepository.save(team);
                    return true;
                }
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
