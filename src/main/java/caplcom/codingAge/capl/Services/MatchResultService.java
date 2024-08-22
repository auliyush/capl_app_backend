package caplcom.codingAge.capl.Services;


import caplcom.codingAge.capl.Models.MatchResult;
import caplcom.codingAge.capl.Models.request.CreateRequests.MatchResultRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateMatchResult;

import java.util.List;

public interface MatchResultService {
    MatchResult getMatchById(String matchId);

    List<MatchResult> getMatchByTeamId(String teamId);

    MatchResult createMatchResult(MatchResultRequest matchResultRequest);

    MatchResult editMatchResult(UpdateMatchResult updateMatchResult);
}
