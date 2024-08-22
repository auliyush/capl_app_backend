package caplcom.codingAge.capl.Models.request.UpdateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateScoreBoardRequest {

    private String scoreboardId;
    private String strikerId;
    private String nonStrikerId;
    private String bowlerId;
    private int totalRuns;
    private double overs;
    private int noOfWickets;
}
