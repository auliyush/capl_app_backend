package caplcom.codingAge.capl.Models.request.CreateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MatchResultRequest {
    private String matchId;
    private String firstTeamScoreBoardId;
    private String secondTeamScoreBoardId;
}
