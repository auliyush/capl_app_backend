package caplcom.codingAge.capl.Utility;

import caplcom.codingAge.capl.Models.Tournament;
import caplcom.codingAge.capl.Services.SeasonService;
import caplcom.codingAge.capl.Services.TeamService;
import caplcom.codingAge.capl.Services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilityClassService {
    @Autowired
    private TournamentService tournamentService;
    @Autowired
    private SeasonService seasonService;
    @Autowired
    private TeamService teamService;

}
