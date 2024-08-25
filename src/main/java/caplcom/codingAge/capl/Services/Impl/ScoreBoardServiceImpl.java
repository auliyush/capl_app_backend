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

    public ScoreBoard createScoreBoard(String matchId, String teamId){
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.setTeamId(teamId);
        scoreBoard.setMatchId(matchId);
        return scoreBoardRepository.save(scoreBoard);
    }

    @Override
    public ScoreBoard getScoreBoardById(String scoreBoardId) {
        return scoreBoardRepository.findById(scoreBoardId).orElse(null);
    }

    @Override
    public ScoreBoard getScoreBoardByMatchAndTeamId(String teamId,String matchId) {
        List <ScoreBoard> scoreBoardList = scoreBoardRepository.findAllByMatchId(matchId);
        for (ScoreBoard scoreBoard : scoreBoardList){
            if(scoreBoard.getTeamId().equals(teamId)){
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
    public void addRuns(String scoreBoardId, int run) {
        ScoreBoard scoreBoard = scoreBoardRepository.findById(scoreBoardId).orElse(null);
         if(scoreBoard != null){
             scoreBoard.setTotalRuns(scoreBoard.getTotalRuns()+run);
         }
    }
    @Override
    public List<ScoreBoard> getListOfScoreBoard() {
        return scoreBoardRepository.findAll();
    }
}
