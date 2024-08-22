package caplcom.codingAge.capl.Repositories;

import caplcom.codingAge.capl.Models.Wicket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WicketRepository extends MongoRepository<Wicket, String> {
    Wicket findByWicketId(String wicketId);

    List<Wicket> findByBowlerId(String bowlerId);

    List<Wicket> findByBatterId(String batterId);
    Wicket findByBatterIdAndTeamId(String batterId, String teamId);
}
