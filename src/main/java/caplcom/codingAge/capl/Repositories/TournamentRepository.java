package caplcom.codingAge.capl.Repositories;

import caplcom.codingAge.capl.Models.Tournament;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends MongoRepository<Tournament, String> {

    Tournament findByTournamentId(String tournamentId);

    Tournament findBySeasonYear(String tournamentSeasonYear);

//    Tournament addTeamsInTournament(Integer tournamentId , Integer teamId);

}