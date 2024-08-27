package caplcom.codingAge.capl.Repositories;

import caplcom.codingAge.capl.Models.TeamStats;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamStatsRepo extends MongoRepository<TeamStats,String> {
    TeamStats findByTeamId(String teamId);

    List<TeamStats> findAllByTournamentId(String tournamentId);
}
