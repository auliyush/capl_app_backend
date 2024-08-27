package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.*;
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
        return scoreBoardRepository.findById(scoreBoardId).orElse(null);
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

    // update scoreBoard api for create initial stats of scoreboard when tap on button start match
// after create match
    @Override
    public ScoreBoard updateScoreBoard(UpdateScoreBoardRequest updateScoreBoardRequest) {
        ScoreBoard scoreBoard = getScoreBoardByMatchAndTeamId(updateScoreBoardRequest.getTeamId(),
                updateScoreBoardRequest.getMatchId());
        if (scoreBoard != null) {
//                scoreBoard.setStrikerId(updateScoreBoardRequest.getStrikerId());
//                scoreBoard.setNonStrikerId(updateScoreBoardRequest.getNonStrikerId());
//                scoreBoard.setBowlerId(updateScoreBoardRequest.getBowlerId());
            if (batterStatService.getBatterStatByPlayerId(updateScoreBoardRequest.getStrikerId(),
                    scoreBoard.getScoreBoardId()) == null) {
                BatterStat striker = batterStatService.createInningBatterStats(scoreBoard.getScoreBoardId(),
                        scoreBoard.getTeamId(), scoreBoard.getStrikerId());
                scoreBoard.getBatterStatList().add(striker);
                scoreBoard.setStrikerId(striker.getStatId());
            }
            if (batterStatService.getBatterStatByPlayerId(updateScoreBoardRequest.getNonStrikerId(),
                    scoreBoard.getScoreBoardId()) == null) {
                BatterStat nonStriker = batterStatService.createInningBatterStats(scoreBoard.getScoreBoardId(),
                        scoreBoard.getTeamId(), scoreBoard.getNonStrikerId());
                scoreBoard.getBatterStatList().add(nonStriker);
                scoreBoard.setStrikerId(nonStriker.getStatId());
            }
            // todo complete this first
            // create initial Striker & non Striker stats opening time
            Match match = matchService.getMatchById(updateScoreBoardRequest.getMatchId());
            String teamId = (match.getFirstTeamId().equals(updateScoreBoardRequest.getTeamId()))
                    ? match.getSecondTeamId() : match.getFirstTeamId();
            scoreBoard.getBowlerStatList().add(bowlerStatService.createInningBowlerStats(scoreBoard.getScoreBoardId(), teamId,
                    updateScoreBoardRequest.getBowlerId()));
            // create initial bowler stat of from opposite team opening time
            return scoreBoardRepository.save(scoreBoard);
        }
        return null;
    }

    @Override
    public boolean addExtrasRun(Extras extras) {
        ScoreBoard scoreBoard = getScoreBoardById(extras.getScoreBoardId());
        if (scoreBoard.isInning()) {
            scoreBoard.setTotalRuns(scoreBoard.getTotalRuns() + extras.getExtraRun());
            scoreBoard.getExtrasList().add(extras);
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
    public boolean addRuns(String scoreBoardId, Integer run) {
        ScoreBoard scoreBoard = scoreBoardRepository.findById(scoreBoardId).orElse(null);
        if (scoreBoard != null) {
            scoreBoard.setTotalRuns(scoreBoard.getTotalRuns() + run);
        }
        batterStatService.addRunInStriker(scoreBoard.getStrikerId(), run);
        bowlerStatService.addRunInBowler(scoreBoard.getBowlerId(), run);
        return true;
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
        if (!scoreBoard.isInning()) {
            return null;
        }
        Match match = matchService.getMatchById(scoreBoard.getMatchId());
        String teamId = (match.getFirstTeamId().equals(scoreBoard.getTeamId()))
                ? match.getSecondTeamId() : match.getFirstTeamId();
        Player player = teamService.getPlayerByJerseyNumber(updateBowler.getNewBowlerJerseyNumber(), teamId);
        if (player != null) {
            BowlerStat bowlerStat = bowlerStatService.getBowlerStatById(player.getPlayerId());
            if (bowlerStat == null) {
                BowlerStat bowlerStat1 = bowlerStatService.createInningBowlerStats(
                        scoreBoard.getScoreBoardId(), teamId, player.getPlayerId());
                scoreBoard.setBowlerId(bowlerStat1.getStatId());
                scoreBoardRepository.save(scoreBoard);
            } else {
                scoreBoard.setBowlerId(bowlerStat.getStatId());
                scoreBoardRepository.save(scoreBoard);
            }
        } else {
            return null;
        }
        scoreBoardRepository.save(scoreBoard);
        return null;
    }

    @Override
    public List<ScoreBoard> getListOfScoreBoard() {
        return scoreBoardRepository.findAll();
    }
}
