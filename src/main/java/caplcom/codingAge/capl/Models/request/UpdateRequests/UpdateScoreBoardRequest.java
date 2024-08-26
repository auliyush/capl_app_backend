package caplcom.codingAge.capl.Models.request.UpdateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateScoreBoardRequest {
    private String matchId;
    private String teamId;
    private boolean inning;
    private String strikerId;
    private String nonStrikerId;
    private String bowlerId;
}
