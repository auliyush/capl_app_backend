package caplcom.codingAge.capl.Repositories;

import caplcom.codingAge.capl.Models.BowlerStat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowlerStatRepository extends MongoRepository<BowlerStat, String> {

}
