package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.Extras;
import caplcom.codingAge.capl.Models.ScoreBoard;
import caplcom.codingAge.capl.Models.request.CreateRequests.ScoreBoardRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateScoreBoardRequest;
import caplcom.codingAge.capl.Repositories.ScoreBoardRepository;
import caplcom.codingAge.capl.Services.ScoreBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreBoardServiceImpl implements ScoreBoardService {

    @Autowired
    private ScoreBoardRepository scoreBoardRepository;

    public ScoreBoard createScoreBoard(ScoreBoardRequest scoreBoardRequest){
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.setFirstTeamId(scoreBoardRequest.getFirstTeamId());
        scoreBoard.setSecondTeamId(scoreBoardRequest.getSecondTeamId());
        scoreBoard.setStrikerId(scoreBoardRequest.getStrikerId());
        scoreBoard.setNonStrikerId(scoreBoardRequest.getNonStrikerId());
        scoreBoard.setBowlerId(scoreBoardRequest.getBowlerId());
        scoreBoard.setTotalRuns(scoreBoardRequest.getTotalRuns());
        scoreBoard.setOvers(scoreBoardRequest.getOvers());
        scoreBoard.setNoOfWickets(scoreBoardRequest.getNoOfWickets());
        return scoreBoardRepository.save(scoreBoard);
    }

    @Override
    public ScoreBoard getScoreBoardById(String scoreBoardId) {
        return scoreBoardRepository.findById(scoreBoardId).orElse(null);
    }


    @Override
    public ScoreBoard getScoreBoardByTeamId(String firstTeamId, String secondTeamId) {
        List <ScoreBoard> scoreBoardList = scoreBoardRepository.findAllByFirstTeamId(firstTeamId);
        for (ScoreBoard scoreBoard : scoreBoardList){
            if (scoreBoard.getSecondTeamId().equals(secondTeamId)){
                return scoreBoard;
            }
        }
        return null;
    }

    @Override
    public ScoreBoard editScoreBoard(UpdateScoreBoardRequest updateScoreBoardRequest) {

        ScoreBoard scoreBoard =scoreBoardRepository.findById(updateScoreBoardRequest.getScoreboardId()).get();
        if (scoreBoard != null){
                scoreBoard.setStrikerId(updateScoreBoardRequest.getStrikerId());
                scoreBoard.setNonStrikerId(updateScoreBoardRequest.getNonStrikerId());
                scoreBoard.setBowlerId(updateScoreBoardRequest.getBowlerId());
                scoreBoard.setTotalRuns(updateScoreBoardRequest.getTotalRuns());
                scoreBoard.setNoOfWickets(updateScoreBoardRequest.getNoOfWickets());
                return scoreBoardRepository.save(scoreBoard);
        }
        return null;
    }

    @Override
    public List<ScoreBoard> getListOfScoreBoard() {
        return scoreBoardRepository.findAll();
    }

    @Override
    public ScoreBoard addExtrasByMatchId(Extras extras) {
        ScoreBoard scoreBoard=scoreBoardRepository.findByMatchId(extras.getMatchId());
        if(scoreBoard!=null)
        {
            scoreBoard.getExtrasList().add(extras);
            scoreBoardRepository.save(scoreBoard);
        }
        return null;
    }
}
