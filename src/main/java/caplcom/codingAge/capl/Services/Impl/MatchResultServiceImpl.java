package caplcom.codingAge.capl.Services.Impl;


import caplcom.codingAge.capl.Models.Match;
import caplcom.codingAge.capl.Models.MatchResult;
import caplcom.codingAge.capl.Models.Stats;
import caplcom.codingAge.capl.Models.request.CreateRequests.MatchResultRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateMatchResult;
import caplcom.codingAge.capl.Repositories.MatchResultRepository;
import caplcom.codingAge.capl.Services.MatchResultService;
import caplcom.codingAge.capl.Services.ScoreBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MatchResultServiceImpl implements MatchResultService {
    @Autowired
    MatchResultRepository matchResultRepository;
    @Autowired
    private ScoreBoardService scoreBoardService;

    @Override
    public MatchResult getMatchResultByMatchId(String matchId) {
        MatchResult matchResult = matchResultRepository.findByMatchId(matchId);
        return matchResult;
    }

    @Override
    public List<MatchResult> getMatchByTeamId(String teamId) {
        List<MatchResult> matchResults = matchResultRepository.findByFirstTeamId(teamId);
        if (matchResults == null) {
            matchResults = matchResultRepository.findBySecondTeamId(teamId);
        }
        if (matchResults != null) {
            return matchResults;
        }
        return new ArrayList<>();
    }

    @Override
    public MatchResult createMatchResult(Match match) {
        MatchResult matchResult = new MatchResult();
        matchResult.setMatchId(match.getMatchId());
        matchResult.setTournamentId(match.getTournamentId());
        matchResult.setFirstTeamId(match.getFirstTeamId());
        matchResult.setFirstTeamTotalRuns(scoreBoardService.getScoreBoardByMatchAndTeamId(
                match.getFirstTeamId(), match.getMatchId()).getTotalRuns());
        matchResult.setFirstTeamTotalWickets(scoreBoardService.getScoreBoardByMatchAndTeamId(
                match.getFirstTeamId(), match.getMatchId()).getTotalWickets());
        matchResult.setSecondTeamId(match.getSecondTeamId());
        matchResult.setSecondTeamTotalRuns(scoreBoardService.getScoreBoardByMatchAndTeamId(
                match.getSecondTeamId(), match.getMatchId()).getTotalRuns());
        matchResult.setSecondTeamTotalWickets(scoreBoardService.getScoreBoardByMatchAndTeamId(
                match.getSecondTeamId(), match.getMatchId()).getTotalWickets());

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
                matchResult.setManOfTheMatchId(highestRunPlayer);
            }else {
                matchResult.setManOfTheMatchId(highestWicketPlayer);
            }
        }else {
            matchResult.setManOfTheMatchId(highestRunPlayer);
        }
        // set winning team is also pending
        matchResultRepository.save(matchResult);
        return matchResult;
    }

    @Override
    public MatchResult updateMatchResult(UpdateMatchResult updateMatchResult) {
        MatchResult matchResult = getMatchResultByMatchId(updateMatchResult.getMatchId());
return matchResult;
    }
}
