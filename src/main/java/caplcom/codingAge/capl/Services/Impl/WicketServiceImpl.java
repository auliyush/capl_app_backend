package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.Wicket;
import caplcom.codingAge.capl.Models.request.CreateRequests.WicketRequest;
import caplcom.codingAge.capl.Repositories.WicketRepository;
import caplcom.codingAge.capl.Services.WicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WicketServiceImpl implements WicketService {

    @Autowired
    private WicketRepository wicketRepository;


    @Override
    public Wicket createWicket(WicketRequest wicketRequest) {
// there is no verification for now!
        // stop for multiple wicket in same batter in same team
        Wicket batter = wicketRepository.findByBatterIdAndTeamId(wicketRequest.getBatterId(), wicketRequest.getTeamId());
        if (batter == null) {
            Wicket wicket = new Wicket();
            wicket.setBatterId(wicketRequest.getBatterId());
            wicket.setBowlerId(wicketRequest.getBowlerId());
            wicket.setTeamId(wicketRequest.getTeamId());
            wicket.setFielderId(wicketRequest.getFielderId());
            wicket.setWicketDescription(wicketRequest.getWicketDescription());
            return wicketRepository.save(wicket);
        } else {
            return new Wicket();
        }
    }

    @Override
    public Wicket getWicketById(String wicketId) {
        Wicket wicket = wicketRepository.findByWicketId(wicketId);
        if(wicket != null) {
            return wicket;
        }
        return new Wicket();
    }

    @Override
    public List<Wicket> getWicketsByBowlerId(String bowlerId) {
        List<Wicket> wickets = wicketRepository.findByBowlerId(bowlerId);
        if (wickets.isEmpty()) {
            return Collections.emptyList();
        }
        return wickets;
    }

    @Override
    public List<Wicket> getWicketsByBatterId(String batterId) {
        List<Wicket> wickets = wicketRepository.findByBatterId(batterId);
        if (wickets.isEmpty()) {
            return Collections.emptyList();
        }
        return wickets;
    }
}
