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
        Player player = new Player();
        player.setPlayerName(playerRequest.getPlayerName());
        player.setPlayerPhone(playerRequest.getPlayerPhone());
        player.setPlayerEmail(playerRequest.getPlayerEmail());
        player.setPlayerPassword(playerRequest.getPlayerPassword());
        player.setPlayerDob(playerRequest.getPlayerDob());
        player.setPlayerAddress(playerRequest.getPlayerAddress());
        player.setPlayerType(playerRequest.getPlayerType());
        return playerRepository.save(player);
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

    @Override
    public String getEconomyRate(String playerId) {
        Player player = playerRepository.findByPlayerId(playerId);
        if(player != null){
            int totalBalls = Integer.parseInt(player.getTotalBalls());
            double totalOvers = totalBalls / 6.0;
            int totalRuns = Integer.parseInt(player.getTotalRuns());
            double economyRate = totalRuns / totalOvers;
            return  Double.toString(economyRate);
        }
        return null;
    }

    @Override
    public String getStikeRate(String playerId) {
        Player player = playerRepository.findByPlayerId(playerId);
        if (player != null){
            int totalRuns = Integer.parseInt(player.getTotalRuns());
            int totalBalls = Integer.parseInt(player.getTotalBalls());
            double strikeRate = (double) totalRuns / totalBalls *100;
            return  Double.toString(strikeRate);
        }
        return null;
        }
    public int getAllFoursByPlayerId(String playerId) {
        Player player=getPlayerById(playerId);
        return player.getTotalFours();
    }

    @Override
    public int getAllSixByPlayerId(String playerId) {
        Player player=getPlayerById(playerId);
        return player.getTotalSixes();
    }
}

