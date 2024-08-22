package caplcom.codingAge.capl.Models.request.UpdateRequests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMatchRequest {
    private String matchId;
    private String creatorId;
    private Integer matchDate;
    private Integer matchTime;
    private double overs;
    private String tossWonTeamId;
    private String selectionOfTossWinningTeam;
}
