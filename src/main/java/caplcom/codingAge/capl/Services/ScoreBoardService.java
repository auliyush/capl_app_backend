package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Extras;
import caplcom.codingAge.capl.Models.ScoreBoard;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateBowler;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateScoreBoardRequest;

import java.util.List;

public interface ScoreBoardService {

    ScoreBoard createScoreBoard(String matchId, String teamId);

    ScoreBoard getScoreBoardById(String scoreBoardId);

    ScoreBoard getScoreBoardByMatchAndTeamId(String teamId, String matchId);

    ScoreBoard updateScoreBoard(UpdateScoreBoardRequest updateScoreBoardRequest);

    boolean addExtrasRun(Extras extras);
    List<ScoreBoard> getListOfScoreBoard();
    boolean addRuns(String scoreBoardId, Integer run);

    ScoreBoard updateBowler(UpdateBowler updateBowler);
}
