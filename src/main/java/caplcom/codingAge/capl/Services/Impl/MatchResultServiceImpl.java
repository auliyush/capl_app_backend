package caplcom.codingAge.capl.Services.Impl;


import caplcom.codingAge.capl.Models.*;
import caplcom.codingAge.capl.Models.request.CreateRequests.MatchResultRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateMatchResult;
import caplcom.codingAge.capl.Repositories.MatchResultRepository;
import caplcom.codingAge.capl.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MatchResultServiceImpl implements MatchResultService {
    @Autowired
    private MatchResultRepository matchResultRepository;
    @Autowired
    private MatchService matchService;
    @Autowired
    private ScoreBoardService scoreBoardService;
//    @Autowired
//    private BatterStatService batterStatService;
//    @Autowired
//    private BowlerStatService bowlerStatService;

    @Override
    public MatchResult getMatchResultByMatchId(String matchId) {
        return matchResultRepository.findByMatchId(matchId);
    }

    @Override
    public List<MatchResult> getMatchResultByTeamId(String teamId) {
        List<MatchResult> matchResults = matchResultRepository.findByFirstTeamId(teamId);
        matchResults.addAll(matchResultRepository.findBySecondTeamId(teamId));
       return matchResults;
    }

    @Override
    public MatchResult createMatchResult(String matchId, String teamFirstScoreBoardId, String teamSecondScoreBoardId) {
        Match match = matchService.getMatchById(matchId);
        ScoreBoard teamFirstScoreBoard = scoreBoardService.getScoreBoardById(teamFirstScoreBoardId);
        ScoreBoard teamSecondScoreBoard = scoreBoardService.getScoreBoardById(teamSecondScoreBoardId);
        MatchResult matchResult = new MatchResult();
        matchResult.setMatchId(match.getMatchId());
        matchResult.setTournamentId(match.getTournamentId());
        matchResult.setFirstTeamId(match.getFirstTeamId());
        matchResult.setFirstTeamId(match.getFirstTeamId());
        matchResult.setFirstTeamTotalRuns(teamFirstScoreBoard.getTotalRuns());
        matchResult.setFirstTeamTotalWickets(teamFirstScoreBoard.getTotalWickets());
        matchResult.setSecondTeamId(match.getSecondTeamId());
        matchResult.setSecondTeamTotalRuns(teamSecondScoreBoard.getTotalRuns());
        matchResult.setSecondTeamTotalWickets(teamSecondScoreBoard.getTotalWickets());

        int highestRunPlayer1 = -99;
        int highestWicketPlayer1 = -99;
        int highestRunPlayer2 = -99;
        int highestWicketPlayer2 = -99;
        String highestRunPlayer = "";
        String highestWicketPlayer = "";
        List<BatterStat> batterStatList = teamFirstScoreBoard.getBatterStatList();
        batterStatList.addAll(teamSecondScoreBoard.getBatterStatList());
        for(BatterStat batterStat : batterStatList){
            if (batterStat.getTotalRuns() > highestRunPlayer1){
                highestRunPlayer1 = batterStat.getTotalRuns();
                highestRunPlayer = batterStat.getPlayerId();
            }
        }
        List<BowlerStat> bowlerStatList = teamFirstScoreBoard.getBowlerStatList();
        bowlerStatList.addAll(teamSecondScoreBoard.getBowlerStatList());
        for (BowlerStat bowlerStat : bowlerStatList){
            if(bowlerStat.getWicketsList().size() > highestWicketPlayer2){
                highestWicketPlayer2 = bowlerStat.getWicketsList().size();
                // incomplete logic not found
                highestWicketPlayer = bowlerStat.getPlayerId();
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
        // set winning team is also pending and man of the match also
        matchResultRepository.save(matchResult);
        return matchResult;
    }

}
