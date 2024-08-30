package caplcom.codingAge.capl.Repositories;


import caplcom.codingAge.capl.Models.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TeamRepository extends MongoRepository<Team, String> {

    Team findByTeamId(String teamId);

    List<Team> findAllByTeamCreatorId(String creatorId);
}
