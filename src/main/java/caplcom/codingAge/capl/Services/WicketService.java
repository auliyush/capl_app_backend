package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Wicket;
import caplcom.codingAge.capl.Models.request.CreateRequests.WicketRequest;

import java.util.List;

public interface WicketService {
    Wicket createWicket(WicketRequest wicketRequest);

    Wicket getWicketById(String wicketId);

    List<Wicket> getWicketsByBowlerId(String bowlerId);

    List<Wicket> getWicketsByBatterId(String batterId);
}
