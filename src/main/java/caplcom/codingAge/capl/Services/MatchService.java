package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Match;
import caplcom.codingAge.capl.Models.request.CreateRequests.MatchRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateMatchRequest;

import java.util.List;

public interface MatchService {
    Match createMatch(MatchRequest matchRequest);
    Match editMatchDetails(UpdateMatchRequest updateMatchRequest);
    Match getMatchById(String id);
    List<Match> getMatchesByTeamId(String teamId);
    Match saveUpdates(Match match);
}
