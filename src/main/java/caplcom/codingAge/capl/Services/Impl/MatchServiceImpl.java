package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.*;
import caplcom.codingAge.capl.Models.request.CreateRequests.MatchRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateMatchRequest;
import caplcom.codingAge.capl.Repositories.MatchRepository;
import caplcom.codingAge.capl.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private TeamService teamService;
    @Autowired
    private  SeasonService seasonService;


    @Override
    public Match createMatch(MatchRequest matchRequest) {
        if (adminUserService.getAdminUserById(matchRequest.getCreatorId()) != null) {
            Team firstTeam = teamService.getTeamById(matchRequest.getFirstTeamId());
            Team secondTeam = teamService.getTeamById(matchRequest.getSecondTeamId());
            if(firstTeam != null && secondTeam != null) {
                Match match = getMatch(matchRequest);
                firstTeam.getMatchList().add(match);
                teamService.saveUpdates(firstTeam);
                secondTeam.getMatchList().add(match);
                teamService.saveUpdates(secondTeam);
                seasonService.addMatchInSeason(match);
                return matchRepository.save(match);
            }
        }
        return null;
    }
// this is static method only for create match
    private Match getMatch(MatchRequest matchRequest) {
        Match match = new Match();
        match.setCreatorId(matchRequest.getCreatorId());
        match.setTournamentId(matchRequest.getTournamentId());
        match.setFirstTeamId(matchRequest.getFirstTeamId());
        match.setSecondTeamId(matchRequest.getSecondTeamId());
        match.setMatchDate(matchRequest.getMatchDate());
        match.setMatchTime(matchRequest.getMatchTime());
        match.setOvers(matchRequest.getOvers());
        match.setTossWonTeamId(matchRequest.getTossWonTeamId());
        match.setSelectionOfTossWinningTeam(matchRequest.getSelectionOfTossWinningTeam());
        match.setMatchStatus(true);
        return match;
    }

    public Match editMatchDetails(UpdateMatchRequest updateMatchRequest) {
        Match match = getMatchById(updateMatchRequest.getMatchId());
        if(match != null){
            if(!match.isMatchStatus()){
                return null;
            }
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
    public Match getMatchById(String matchId) {
        return matchRepository.findByMatchId(matchId);
    }

//    @Override
//    public List<Match> getMatchesByTeamId(String teamId) {
//        return teamService.getTeamById(teamId).getMatchList();
//    }

    @Override
    public Match updateMatch(String matchId) {
        Match match = getMatchById(matchId);
        if(match.isMatchStatus()){
           return null;
        }
        return matchRepository.save(match);
    }

    @Override
    public Match saveUpdates(Match match) {
        return matchRepository.save(match);
    }
}
