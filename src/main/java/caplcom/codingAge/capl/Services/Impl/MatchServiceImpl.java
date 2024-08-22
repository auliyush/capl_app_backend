package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.Match;
import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.request.CreateRequests.MatchRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateMatchRequest;
import caplcom.codingAge.capl.Repositories.MatchRepository;
import caplcom.codingAge.capl.Services.MatchService;
import caplcom.codingAge.capl.Services.PlayerService;
import caplcom.codingAge.capl.Services.TeamService;
import caplcom.codingAge.capl.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private UserService userService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private TeamService teamService;
    @Override
    public Match createMatch(MatchRequest matchRequest) {
//        if (userService.getUserByUserId(matchRequest.getCreatorId()) != null) {
//            Team firstTeam = teamService.getTeamById(matchRequest.getFirstTeamId());
            Team firstTeam = new Team();
            Team secondTeam = new Team();
            // both are same things why...
//            Team secondTeam = teamService.getTeamById(matchRequest.getFirstTeamId());
//            if(firstTeam != null && secondTeam != null) {
                Match match = new Match();
                match.setCreatorId(matchRequest.getCreatorId());
                match.setTournamentId(matchRequest.getTournamentId());
                match.setFirstTeamId(matchRequest.getFirstTeamId());
                match.setSecondTeamId(matchRequest.getSecondTeamId());
                match.setMatchDate(matchRequest.getMatchDate());
                match.setMatchTime(matchRequest.getMatchTime());
                match.setOvers(matchRequest.getOvers());
                firstTeam.getMatchList().add(match);
                teamService.saveUpdates(firstTeam);
                secondTeam.getMatchList().add(match);
                teamService.saveUpdates(secondTeam);
                return matchRepository.save(match);
//            }
//        }
//        else if(playerService.getPlayerById(matchRequest.getCreatorId()) != null){
//            Team firstTeam = teamService.getTeamById(matchRequest.getFirstTeamId());
//            Team secondTeam = teamService.getTeamById(matchRequest.getFirstTeamId());
//            if(firstTeam != null && secondTeam != null){
//                Match match = new Match();
//                match.setCreatorId(matchRequest.getCreatorId());
//                match.setTournamentId(matchRequest.getTournamentId());
//                match.setFirstTeamId(matchRequest.getFirstTeamId());
//                match.setSecondTeamId(matchRequest.getSecondTeamId());
//                match.setMatchDate(matchRequest.getMatchDate());
//                match.setMatchTime(matchRequest.getMatchTime());
//                match.setOvers(matchRequest.getOvers());
//                firstTeam.getMatchList().add(match);
//                teamService.saveUpdates(firstTeam);
//                secondTeam.getMatchList().add(match);
//                teamService.saveUpdates(secondTeam);
//                return matchRepository.save(match);
//            }
//        }

    }

    public Match editMatchDetails(UpdateMatchRequest updateMatchRequest) {
        Match match = getMatchById(updateMatchRequest.getMatchId());
        if(match != null){
            if(Objects.equals(match.getCreatorId(), updateMatchRequest.getCreatorId())){
                match.setMatchDate(updateMatchRequest.getMatchDate());
                match.setMatchTime(updateMatchRequest.getMatchTime());
                match.setOvers(updateMatchRequest.getOvers());
                match.setTossWonTeamId(updateMatchRequest.getTossWonTeamId());
                match.setSelectionOfTossWinningTeam(updateMatchRequest.getSelectionOfTossWinningTeam());
                return matchRepository.save(match);
            }
        }
        return null;
    }
    @Override
    public Match getMatchById(String id) {
        return matchRepository.findByMatchId(id);
    }

    @Override
    public List<Match> getMatchesByTeamId(String teamId) {
        return teamService.getTeamById(teamId).getMatchList();
    }
    @Override
    public Match saveUpdates(Match match) {
        return matchRepository.save(match);
    }
}
