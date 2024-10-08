package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Extras;
import caplcom.codingAge.capl.Models.ScoreBoard;
import caplcom.codingAge.capl.Models.Wicket;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateBatter;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateBowler;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateScoreBoardRequest;

import java.util.List;

public interface ScoreBoardService {

    ScoreBoard createScoreBoard(String matchId, String teamId);

    ScoreBoard getScoreBoardById(String scoreBoardId);

    ScoreBoard getScoreBoardByMatchAndTeamId(String teamId, String matchId);

    ScoreBoard updateScoreBoard(UpdateScoreBoardRequest updateScoreBoardRequest);

    boolean addExtrasRun(Extras extras);

    ScoreBoard addRuns(String scoreBoardId, Integer run);

    ScoreBoard updateBowler(UpdateBowler updateBowler);

    ScoreBoard addWicket(Wicket wicket);

    ScoreBoard updateBatter(UpdateBatter updateBatter);

    List<ScoreBoard> getListOfScoreBoard();

    ScoreBoard saveUpdates(ScoreBoard scoreBoard);
}
