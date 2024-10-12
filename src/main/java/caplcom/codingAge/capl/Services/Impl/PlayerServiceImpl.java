package caplcom.codingAge.capl.Services.Impl;


import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.request.CreateRequests.PlayerRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdatePlayer;
import caplcom.codingAge.capl.Repositories.PlayerRepository;
import caplcom.codingAge.capl.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player createPlayer(PlayerRequest playerRequest) {
        Player player = getPlayer(playerRequest);
        return playerRepository.save(player);
    }

    private static Player getPlayer(PlayerRequest playerRequest) {
        Player player = new Player();
        player.setPlayerName(playerRequest.getPlayerName());
        player.setPlayerPhone(playerRequest.getPlayerPhone());
        player.setPlayerEmail(playerRequest.getPlayerEmail());
        player.setPlayerPassword(playerRequest.getPlayerPassword());
        return player;
    }

    @Override
    public Player getPlayerById(String playerId) {
        return playerRepository.findByPlayerId(playerId);
    }

    @Override
    public Player updatePlayer(UpdatePlayer updatePlayer) {
        Player player = getPlayerById(updatePlayer.getPlayerId());
        if(player == null){
            return null;
        }

        if(!getByPhoneNumber(updatePlayer.getPlayerPhone()).getPlayerId().equals(updatePlayer.getPlayerId())){
            return null;
        }
        if(!getByEmail(updatePlayer.getPlayerEmail()).getPlayerId().equals(updatePlayer.getPlayerId())){
            return null;
        }
        player.setPlayerProfilePhotoUrl(updatePlayer.getPlayerProfilePhotoUrl());
        player.setPlayerName(updatePlayer.getPlayerName());
        player.setPlayerNickName(updatePlayer.getPlayerNickName());
        player.setPlayerPhone(updatePlayer.getPlayerPhone());
        player.setPlayerEmail(updatePlayer.getPlayerEmail());
        player.setPlayerDob(updatePlayer.getPlayerDob());
        player.setPlayerAddress(updatePlayer.getPlayerAddress());
        player.setPlayerType(updatePlayer.getPlayerType());
        player.setPlayerSubType(updatePlayer.getPlayerSubType());
        player.setPlayerPassword(updatePlayer.getPlayerPassword());
        return playerRepository.save(player);
    }

    @Override
    public Player getByPhoneNumber(String phoneNumber) {
        return playerRepository.findByPlayerPhone(phoneNumber);
    }

    @Override
    public Player getByEmail(String userEmail) {
        return playerRepository.findByPlayerEmail(userEmail);
    }

    @Override
    public List<Player> getListOfPlayer() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> getListOfPlayerByRole(String playerRole) {
        return playerRepository.findAllByPlayerType(playerRole);
    }


    @Override
    public Player saveUpdates(Player player) {
        return playerRepository.save(player);
    }

}

