package caplcom.codingAge.capl.Repositories;

import caplcom.codingAge.capl.Models.ScoreBoard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreBoardRepository extends MongoRepository <ScoreBoard, String> {

    ScoreBoard findByFirstTeamId (String firstTeamId);

    List<ScoreBoard> findAllByFirstTeamId(String firstTeamId);

    ScoreBoard findByMatchId(String matchId);
}
