package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Extras;
import caplcom.codingAge.capl.Models.ScoreBoard;
import caplcom.codingAge.capl.Models.request.CreateRequests.ScoreBoardRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateScoreBoardRequest;

import java.util.List;

public interface ScoreBoardService {

    ScoreBoard createScoreBoard(ScoreBoardRequest scoreBoardRequest);

    ScoreBoard getScoreBoardById(String scoreBoardId);

    ScoreBoard getScoreBoardByTeamId(String firstTeamId,String secondTeamId);

    ScoreBoard editScoreBoard(UpdateScoreBoardRequest updateScoreBoardRequest);

    List<ScoreBoard> getListOfScoreBoard();
    ScoreBoard addExtrasByMatchId(Extras extras);
}
