package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.*;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateBatter;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateBowler;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateScoreBoardRequest;
import caplcom.codingAge.capl.Repositories.ScoreBoardRepository;
import caplcom.codingAge.capl.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreBoardServiceImpl implements ScoreBoardService {

    @Autowired
    private ScoreBoardRepository scoreBoardRepository;
    @Autowired
    private MatchService matchService;
    @Autowired
    private BatterStatService batterStatService;
    @Autowired
    private BowlerStatService bowlerStatService;
    @Autowired
    private TeamService teamService;

    public ScoreBoard createScoreBoard(String matchId, String teamId) {
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.setTeamId(teamId);
        scoreBoard.setMatchId(matchId);
        return scoreBoardRepository.save(scoreBoard);
    }

    @Override
    public ScoreBoard getScoreBoardById(String scoreBoardId) {
        return scoreBoardRepository.findByScoreBoardId(scoreBoardId);
    }

    @Override
    public ScoreBoard getScoreBoardByMatchAndTeamId(String teamId, String matchId) {
        List<ScoreBoard> scoreBoardList = scoreBoardRepository.findAllByMatchId(matchId);
        for (ScoreBoard scoreBoard : scoreBoardList) {
            if (scoreBoard.getTeamId().equals(teamId)) {
                return scoreBoard;
            }
        }
        return null;
    }

    @Override
    public ScoreBoard updateScoreBoard(UpdateScoreBoardRequest updateScoreBoardRequest) {
        ScoreBoard scoreBoard = getScoreBoardByMatchAndTeamId(updateScoreBoardRequest.getTeamId(),
                updateScoreBoardRequest.getMatchId());
        if (scoreBoard != null) {
            if (!scoreBoard.isInning()) {
                return null;
            }
            if (batterStatService.getBatterStatByPlayerId(updateScoreBoardRequest.getStrikerId(),
                    scoreBoard.getScoreBoardId()) == null) {
                BatterStat striker = batterStatService.createInningBatterStats(scoreBoard.getScoreBoardId(),
                        scoreBoard.getTeamId(), updateScoreBoardRequest.getStrikerId());
                scoreBoard.getBatterStatList().add(striker);
                scoreBoard.setStrikerId(striker.getStatId());
            } else {
                return null;
            }
            if (batterStatService.getBatterStatByPlayerId(updateScoreBoardRequest.getNonStrikerId(),
                    scoreBoard.getScoreBoardId()) == null) {
                BatterStat nonStriker = batterStatService.createInningBatterStats(scoreBoard.getScoreBoardId(),
                        scoreBoard.getTeamId(), updateScoreBoardRequest.getNonStrikerId());
                scoreBoard.getBatterStatList().add(nonStriker);
                scoreBoard.setNonStrikerId(nonStriker.getStatId());
            }
            Match match = matchService.getMatchById(updateScoreBoardRequest.getMatchId());
            String teamId = (match.getFirstTeamId().equals(updateScoreBoardRequest.getTeamId()))
                    ? match.getSecondTeamId() : match.getFirstTeamId();

            BowlerStat bowlerStat = bowlerStatService.getBowlerStatByPlayerId(scoreBoard.getScoreBoardId(),
                    scoreBoard.getBowlerId());
            if (bowlerStat == null) {
                bowlerStat = bowlerStatService.createInningBowlerStats(scoreBoard.getScoreBoardId(),
                        teamId, updateScoreBoardRequest.getBowlerId());
                scoreBoard.getBowlerStatList().add(bowlerStat);
                scoreBoard.setBowlerId(bowlerStat.getStatId());
            } else {
                scoreBoard.getBowlerStatList().add(bowlerStat);
                scoreBoard.setBowlerId(bowlerStat.getStatId());
            }
            return scoreBoardRepository.save(scoreBoard);
        }
        return null;
    }

    @Override
    public boolean addExtrasRun(Extras extras) {
        ScoreBoard scoreBoard = getScoreBoardById(extras.getScoreBoardId());
        if (scoreBoard.isInning()) {
            scoreBoard.setTotalRuns(scoreBoard.getTotalRuns() + extras.getExtraRun());
            for (BowlerStat bowlerStat : scoreBoard.getBowlerStatList()) {
                if (bowlerStat.getStatId().equals(scoreBoard.getBowlerId())) {
                    bowlerStatService.addExtraRunInBowlerStats(extras.getExtraRun(), bowlerStat.getStatId());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public ScoreBoard addRuns(String scoreBoardId, Integer run) {
        ScoreBoard scoreBoard = scoreBoardRepository.findByScoreBoardId(scoreBoardId);
        if (scoreBoard != null) {
            if(!scoreBoard.isInning()){
                return null;
            }
            scoreBoard.setTotalRuns(scoreBoard.getTotalRuns() + run);
        }
        batterStatService.addRunInStriker(scoreBoard.getStrikerId(), run);
        bowlerStatService.addRunInBowler(scoreBoard.getBowlerId(), run);
        return scoreBoardRepository.save(scoreBoard);
    }

    @Override
    public ScoreBoard addWicket(Wicket wicket) {
        ScoreBoard scoreBoard = getScoreBoardById(wicket.getScoreBoardId());
        scoreBoard.setNoOfWickets(scoreBoard.getNoOfWickets() + 1);
        bowlerStatService.addWicketInBowlerStat(wicket);
        return scoreBoardRepository.save(scoreBoard);
    }

    @Override
    public ScoreBoard updateBowler(UpdateBowler updateBowler) {
        ScoreBoard scoreBoard = getScoreBoardById(updateBowler.getScoreBoardId());
        if(scoreBoard == null){
            return null;
        }
        if (!scoreBoard.isInning()) {
            return null;
        }
        Match match = matchService.getMatchById(scoreBoard.getMatchId());
        String teamId = (match.getFirstTeamId().equals(scoreBoard.getTeamId()))
                ? match.getSecondTeamId() : match.getFirstTeamId();
        Player player = teamService.getPlayerByJerseyNumber(updateBowler.getNewBowlerJerseyNumber(), teamId);
        if (player != null) {
            BowlerStat bowlerStat = bowlerStatService.getBowlerStatByPlayerId(
                    scoreBoard.getScoreBoardId(), player.getPlayerId());
            if (bowlerStat == null) {
                 bowlerStat = bowlerStatService.createInningBowlerStats(
                        scoreBoard.getScoreBoardId(), teamId, player.getPlayerId());
                scoreBoard.setBowlerId(bowlerStat.getStatId());
                scoreBoard.getBowlerStatList().add(bowlerStat);
                scoreBoardRepository.save(scoreBoard);
            } else {
                scoreBoard.setBowlerId(bowlerStat.getStatId());
                scoreBoardRepository.save(scoreBoard);
            }
        } else {
            return null;
        }
       return scoreBoardRepository.save(scoreBoard);
    }

    @Override
    public ScoreBoard updateBatter(UpdateBatter updateBatter) {
        ScoreBoard scoreBoard = getScoreBoardById(updateBatter.getScoreBoardId());
        if (scoreBoard == null){
            return null;
        }
        if (!scoreBoard.isInning()) {
            return null;
        }
//        Match match = matchService.getMatchById(scoreBoard.getMatchId());
        Player player = teamService.getPlayerByJerseyNumber(
                updateBatter.getNewBatterJerseyNumber(), scoreBoard.getTeamId());
        if (player != null) {
            BatterStat batterStat = batterStatService.getBatterStatByPlayerId(
                    updateBatter.getNewBatterId(), scoreBoard.getScoreBoardId());
            if (batterStat == null) {
                 batterStat = batterStatService.createInningBatterStats(
                        scoreBoard.getScoreBoardId(), scoreBoard.getTeamId(),
                        updateBatter.getNewBatterId());
                if (scoreBoard.getStrikerId().equals(updateBatter.getPreviousBatterId())) {
                    scoreBoard.setStrikerId(batterStat.getStatId());
                } else {
                    scoreBoard.setNonStrikerId(batterStat.getStatId());
                }
                scoreBoardRepository.save(scoreBoard);
            }else {
                return null;
            }
        }else {
            return null;
        }
        return scoreBoardRepository.save(scoreBoard);
    }

    @Override
    public List<ScoreBoard> getListOfScoreBoard() {
        return scoreBoardRepository.findAll();
    }
}
