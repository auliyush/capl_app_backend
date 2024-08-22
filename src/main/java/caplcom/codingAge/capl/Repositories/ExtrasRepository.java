package caplcom.codingAge.capl.Repositories;

import caplcom.codingAge.capl.Models.Extras;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtrasRepository extends MongoRepository<Extras, String> {

    List<Extras> findByTeamId(String teamId);
}
