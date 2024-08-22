package caplcom.codingAge.capl.Services.Impl;


import caplcom.codingAge.capl.Models.MatchResult;
import caplcom.codingAge.capl.Models.request.CreateRequests.MatchResultRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateMatchResult;
import caplcom.codingAge.capl.Repositories.MatchResultRepository;
import caplcom.codingAge.capl.Services.MatchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchResultServiceImpl implements MatchResultService {
    @Autowired
    MatchResultRepository matchResultRepository;

    @Override
    public MatchResult getMatchById(String matchId) {
        MatchResult matchResult = matchResultRepository.findByMatchId(matchId);
        if (matchResult != null) {
            return matchResult;
        }

        return new MatchResult();
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
    public MatchResult createMatchResult(MatchResultRequest matchResultRequest) {
        MatchResult matchResult = new MatchResult();
        matchResult.setFirstTeamId(matchResultRequest.getFirstTeamId());
        matchResult.setSecondTeamId(matchResultRequest.getSecondTeamId());
        matchResult.setMatchDate(matchResultRequest.getMatchDate());
        matchResult.setMatchTime(matchResultRequest.getMatchTime());
        matchResult.setScoreCard(matchResultRequest.getScoreCard());
        matchResult.setTossWon(matchResultRequest.getTossWon());
        matchResult.setTossSelected(matchResultRequest.getTossSelected());
        matchResult.setTournamentId(matchResultRequest.getTournamentId());
        matchResultRepository.save(matchResult);
        return matchResult;
    }

    @Override
    public MatchResult editMatchResult(UpdateMatchResult updateMatchResult) {
        MatchResult matchResult = matchResultRepository.findById(updateMatchResult.getId()).get();
        if (matchResult != null) {
            matchResult.setFirstTeamId(updateMatchResult.getFirstTeamId());
            matchResult.setSecondTeamId(updateMatchResult.getSecondTeamId());
            matchResult.setMatchDate(updateMatchResult.getMatchDate());
            matchResult.setMatchTime(updateMatchResult.getMatchTime());
            matchResult.setScoreCard(updateMatchResult.getScoreCard());
            matchResult.setTossWon(updateMatchResult.getTossWon());
            matchResult.setTossSelected(updateMatchResult.getTossSelected());
            matchResult.setTournamentId(updateMatchResult.getTournamentId());
            matchResultRepository.save(matchResult);
            return matchResult;
        }
        return null;
    }
}
