package caplcom.codingAge.capl.Repositories;

import caplcom.codingAge.capl.Models.MatchResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchResultRepository extends MongoRepository<MatchResult, String> {
    MatchResult findByMatchId(String matchId);


    List<MatchResult> findByFirstTeamId(String teamId);

    List<MatchResult> findBySecondTeamId(String teamId);
}
