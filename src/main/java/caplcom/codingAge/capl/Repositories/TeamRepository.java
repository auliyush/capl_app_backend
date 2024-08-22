package caplcom.codingAge.capl.Repositories;


import caplcom.codingAge.capl.Models.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {

    Team findByTeamCreatorId(String creatorId);

    Team findByTeamId(String teamId);
}
