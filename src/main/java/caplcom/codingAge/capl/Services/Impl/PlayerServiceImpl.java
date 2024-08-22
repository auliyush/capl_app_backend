package caplcom.codingAge.capl.Services.Impl;


import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.request.CreateRequests.PlayerRequest;
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
        if(playerRepository.findByPlayerName(playerRequest.getPlayerName()) == null){
            if(playerRepository.findByPlayerPhone(playerRequest.getPlayerPhone()) == null){
                if(playerRepository.findByPlayerEmail(playerRequest.getPlayerEmail()) == null){
                    Player player = getPlayer(playerRequest);
                    return playerRepository.save(player);
                }
            }
        }
        return null;
    }

    private static Player getPlayer(PlayerRequest playerRequest) {
        Player player = new Player();
        player.setPlayerName(playerRequest.getPlayerName());
        player.setPlayerPhone(playerRequest.getPlayerPhone());
        player.setPlayerEmail(playerRequest.getPlayerEmail());
        player.setPlayerPassword(playerRequest.getPlayerPassword());
        player.setPlayerDob(playerRequest.getPlayerDob());
        player.setPlayerAddress(playerRequest.getPlayerAddress());
        player.setPlayerType(playerRequest.getPlayerType());
        return player;
    }

    @Override
    public Player getPlayerById(String playerId) {
        return playerRepository.findByPlayerId(playerId);
    }
    @Override
    public List<Player> getListOfPlayer() {
        return playerRepository.findAll();
    }

    @Override
    public Player saveUpdates(Player player) {
        return playerRepository.save(player);
    }

}

