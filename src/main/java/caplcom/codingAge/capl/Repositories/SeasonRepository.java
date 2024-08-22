package caplcom.codingAge.capl.Repositories;

import caplcom.codingAge.capl.Models.Season;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends MongoRepository<Season, String> {
    Season findBySeasonYear(String seasonYear);
}
