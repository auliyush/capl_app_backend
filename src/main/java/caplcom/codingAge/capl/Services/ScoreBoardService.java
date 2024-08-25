package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Extras;
import caplcom.codingAge.capl.Models.ScoreBoard;
import caplcom.codingAge.capl.Models.request.CreateRequests.ScoreBoardRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateScoreBoardRequest;

import java.util.List;

public interface ScoreBoardService {

    ScoreBoard createScoreBoard(String matchId, String teamId);

    ScoreBoard getScoreBoardById(String scoreBoardId);

    ScoreBoard getScoreBoardByMatchAndTeamId(String teamId, String matchId);

    ScoreBoard editScoreBoard(UpdateScoreBoardRequest updateScoreBoardRequest);

    List<ScoreBoard> getListOfScoreBoard();
    void addRuns(String scoreBoardId, int run);
}
