package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Stats;
import caplcom.codingAge.capl.Models.request.CreateRequests.StatsRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateStats;

import java.util.List;

public interface StatsService {
    Stats createStats(StatsRequest statsRequest);

    Stats getStatsById(String statsId);

    Stats updateStats(UpdateStats updateStats);

    List<Stats> getAll();
}