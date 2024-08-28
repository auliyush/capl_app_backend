package caplcom.codingAge.capl.Services;


import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.request.CreateRequests.PlayerRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdatePlayer;

import java.util.List;

public interface PlayerService {
    Player createPlayer(PlayerRequest playerRequest);

    Player getPlayerById(String playerId);

    List<Player> getListOfPlayer();

    Player saveUpdates(Player player);

    Player getByPhoneNumber(String phoneNumber);

    Player getByEmail(String userEmail);

    List<Player> getListOfPlayerByRole(String playerRole);

    Player updatePlayer(UpdatePlayer updatePlayer);
}
