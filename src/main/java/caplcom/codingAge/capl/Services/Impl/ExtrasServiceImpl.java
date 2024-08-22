package caplcom.codingAge.capl.Services.Impl;


import caplcom.codingAge.capl.Models.Extras;
import caplcom.codingAge.capl.Models.request.CreateRequests.ExtrasRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateExtras;
import caplcom.codingAge.capl.Repositories.ExtrasRepository;
import caplcom.codingAge.capl.Services.ExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExtrasServiceImpl implements ExtrasService {

    @Autowired
    ExtrasRepository extrasRepository;
    @Autowired
    ScoreBoardServiceImpl scoreBoardService;

    @Override
    public Extras createExtras(ExtrasRequest extrasRequest) {
        Extras extras = new Extras();
        extras.setTeamId(extrasRequest.getTeamId());
        extras.setWideRun(extrasRequest.getWideRun());
        extras.setLegByRun(extrasRequest.getLegByRun());
        return extrasRepository.save(extras);
    }

    @Override
    public Extras getExtrasById(String id) {
        Extras extras = (extrasRepository.findById(id)).get();
        if (extras != null) {
            return extras;
        }
        return new Extras();
    }

    @Override
    public List<Extras> getExtrasByTeamId(String teamId) {
        List<Extras> extrasList = extrasRepository.findByTeamId(teamId);
        if (extrasList != null) {
            return extrasList;
        }
        return new ArrayList<>();
    }

    @Override
    public Extras updateExtrasById(UpdateExtras updateExtras) {
        Extras extras = extrasRepository.findById(updateExtras.getId()).get();
        if (extras != null) {
            extras.setTeamId(updateExtras.getTeamId());
            extras.setWideRun(updateExtras.getWideRun());
            extras.setLegByRun(updateExtras.getLegByRun());
            return extrasRepository.save(extras);
        }

        return new Extras();
    }
}
