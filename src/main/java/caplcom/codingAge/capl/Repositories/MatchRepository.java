package caplcom.codingAge.capl.Repositories;

import caplcom.codingAge.capl.Models.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends MongoRepository<Match, String> {
    Match findByMatchId(String id);
}
