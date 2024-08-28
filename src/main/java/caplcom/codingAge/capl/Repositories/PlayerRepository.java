package caplcom.codingAge.capl.Repositories;


import caplcom.codingAge.capl.Models.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    Player findByPlayerId(String playerId);

    Player findByPlayerPhone(String playerPhone);

    Player findByPlayerEmail(String playerEmail);

    List<Player> findAllByPlayerType(String playerRole);
}
