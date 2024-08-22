package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.Match;
import caplcom.codingAge.capl.Models.Stats;
import caplcom.codingAge.capl.Models.Team;
import caplcom.codingAge.capl.Models.request.CreateRequests.MatchRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateMatchRequest;
import caplcom.codingAge.capl.Repositories.MatchRepository;
import caplcom.codingAge.capl.Services.*;
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
    @Autowired
    private StatsService statsService;
    @Override
    public Match createMatch(MatchRequest matchRequest) {
        if (userService.getUserByUserId(matchRequest.getCreatorId()) != null) {
            Team firstTeam = teamService.getTeamById(matchRequest.getFirstTeamId());
            Team secondTeam = teamService.getTeamById(matchRequest.getSecondTeamId());
            if(firstTeam != null && secondTeam != null) {
                Match match = getMatch(matchRequest);
                firstTeam.getMatchList().add(match);
                teamService.saveUpdates(firstTeam);
                secondTeam.getMatchList().add(match);
                teamService.saveUpdates(secondTeam);
                return matchRepository.save(match);
            }
        }
        else if(playerService.getPlayerById(matchRequest.getCreatorId()) != null){
            Team firstTeam = teamService.getTeamById(matchRequest.getFirstTeamId());
            Team secondTeam = teamService.getTeamById(matchRequest.getFirstTeamId());
            if(firstTeam != null && secondTeam != null){
                Match match = getMatch(matchRequest);
                firstTeam.getMatchList().add(match);
                teamService.saveUpdates(firstTeam);
                secondTeam.getMatchList().add(match);
                teamService.saveUpdates(secondTeam);
                return matchRepository.save(match);
            }
        }
        return null;
    }

    private static Match getMatch(MatchRequest matchRequest) {
        Match match = new Match();
        match.setCreatorId(matchRequest.getCreatorId());
        match.setTournamentId(matchRequest.getTournamentId());
        match.setFirstTeamId(matchRequest.getFirstTeamId());
        match.setSecondTeamId(matchRequest.getSecondTeamId());
        match.setMatchDate(matchRequest.getMatchDate());
        match.setMatchTime(matchRequest.getMatchTime());
        match.setOvers(matchRequest.getOvers());
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
    public Match getMatchById(String id) {
        return matchRepository.findByMatchId(id);
    }

    @Override
    public List<Match> getMatchesByTeamId(String teamId) {
        return teamService.getTeamById(teamId).getMatchList();
    }

    @Override
    public Match updateMatch(String matchId) {
        Match match = getMatchById(matchId);
        if(match.isMatchStatus()){
           return null;
        }
        int highestRunPlayer1 = -99;
        int highestWicketPlayer1 = -99;
        int highestRunPlayer2 = -99;
        int highestWicketPlayer2 = -99;
        String highestRunPlayer = "";
        String highestWicketPlayer = "";
        for(Stats stats : match.getPlayers()){
            if (stats.getTotalRuns() > highestRunPlayer1){
                highestRunPlayer1 = stats.getTotalRuns();
                highestWicketPlayer1 = stats.getWickets().size();
                highestRunPlayer = stats.getPlayerId();
            }
            if(stats.getWickets().size() > highestWicketPlayer2){
                highestWicketPlayer2 = stats.getWickets().size();
                highestRunPlayer2 = stats.getTotalRuns();
                highestWicketPlayer = stats.getPlayerId();
            }
        }
        highestRunPlayer1 = highestRunPlayer1 + (highestWicketPlayer1 * 20);
        highestRunPlayer2 = highestRunPlayer2 + (highestWicketPlayer2 * 20);
        if(!Objects.equals(highestRunPlayer, highestWicketPlayer)){
            if(highestRunPlayer1 > highestRunPlayer2){
                match.setManOfTheMatchPlayerId(highestRunPlayer);
            }else {
                match.setManOfTheMatchPlayerId(highestWicketPlayer);
            }
        }else {
            match.setManOfTheMatchPlayerId(highestRunPlayer);
        }
        return matchRepository.save(match);
    }

    @Override
    public Match saveUpdates(Match match) {
        return matchRepository.save(match);
    }
}
