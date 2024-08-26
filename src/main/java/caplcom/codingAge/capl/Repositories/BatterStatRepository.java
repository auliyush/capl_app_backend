package caplcom.codingAge.capl.Repositories;

import caplcom.codingAge.capl.Models.BatterStat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatterStatRepository extends MongoRepository<BatterStat, String> {

    List<BatterStat> findAllByScoreBoardId(String scoreBoardId);

    BatterStat findByStatId(String statId);
}
