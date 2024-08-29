package caplcom.codingAge.capl.Services.Impl;


import caplcom.codingAge.capl.Exception.ApplicationException;
import caplcom.codingAge.capl.Models.Extras;
import caplcom.codingAge.capl.Models.ScoreBoard;
import caplcom.codingAge.capl.Models.request.CreateRequests.ExtrasRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateExtras;
import caplcom.codingAge.capl.Repositories.ExtrasRepository;
import caplcom.codingAge.capl.Services.ExtrasService;
import caplcom.codingAge.capl.Services.ScoreBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExtrasServiceImpl implements ExtrasService {

    @Autowired
    private ExtrasRepository extrasRepository;
    @Autowired
    private ScoreBoardService scoreBoardService;

    @Override
    public Extras createExtras(ExtrasRequest extrasRequest) {
        ScoreBoard scoreBoard = scoreBoardService.getScoreBoardById(extrasRequest.getScoreBoardId());
        List<Extras> extrasList = scoreBoard.getExtrasList();
        for(Extras extras : extrasList){
            if(extras.getExtraDescription().equals(extrasRequest.getExtraDescription())){
                extras.setExtraRun(extras.getExtraRun() + extrasRequest.getExtraRuns());
                scoreBoard.setExtrasList(extrasList);
                scoreBoardService.addExtrasRun(extras);
                return extrasRepository.save(extras);
            }
        }
        Extras extras = new Extras();
        extras.setExtraDescription(extrasRequest.getExtraDescription());
        extras.setExtraRun(extrasRequest.getExtraRuns());
        scoreBoard.getExtrasList().add(extras);
        scoreBoardService.saveUpdates(scoreBoard);
        return extrasRepository.save(extras);
    }

    @Override
    public Extras getExtrasById(String id) {
        return extrasRepository.findByExtrasId(id);
    }

    @Override
    public Extras getExtrasByScoreBoardId(String scoreBoardId) {
        Extras extrasList = extrasRepository.findByScoreBoardId(scoreBoardId);
        if(extrasList != null) {
            return extrasList;
        }else {
            return null;
        }
    }


    // there is no need of update extras
//    @Override
//    public Extras updateExtrasById(UpdateExtras updateExtras) {
//        Extras extras = extrasRepository.findById(updateExtras.getId()).get();
//        if (extras != null) {
//            extras.setTeamId(updateExtras.getTeamId());
//            extras.setWideRun(updateExtras.getWideRun());
//            extras.setLegByRun(updateExtras.getLegByRun());
//            return extrasRepository.save(extras);
//        }
//
//        return new Extras();
//    }
}
