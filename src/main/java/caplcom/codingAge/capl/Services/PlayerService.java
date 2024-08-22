package caplcom.codingAge.capl.Services;


import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.request.CreateRequests.PlayerRequest;

import java.util.List;

public interface PlayerService {
    Player createPlayer(PlayerRequest playerRequest);
    Player getPlayerById(String playerId);
    List<Player> getListOfPlayer();
    Player saveUpdates(Player player);
}
