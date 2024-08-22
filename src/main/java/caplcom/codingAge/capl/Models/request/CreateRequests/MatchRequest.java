package caplcom.codingAge.capl.Models.request.CreateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MatchRequest {
    private String tournamentId;
    private String creatorId;
    private String firstTeamId;
    private String secondTeamId;
    private Integer matchDate;
    private Integer matchTime;
    private double overs;
}
