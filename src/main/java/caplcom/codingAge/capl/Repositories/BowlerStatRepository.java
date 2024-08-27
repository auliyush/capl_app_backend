package caplcom.codingAge.capl.Repositories;

import caplcom.codingAge.capl.Models.BowlerStat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BowlerStatRepository extends MongoRepository<BowlerStat, String> {

    BowlerStat findByStatId(String bowlerId);

    BowlerStat findByPlayerId(String playerId);

    List<BowlerStat> findAllByScoreBoardId(String scoreBoardId);
}
