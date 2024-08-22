package caplcom.codingAge.capl.Repositories;


import caplcom.codingAge.capl.Models.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    Player findByPlayerId(String playerId);
}
