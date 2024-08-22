package caplcom.codingAge.capl.Models.request.CreateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ScoreBoardRequest {

    private String firstTeamId;
    private String secondTeamId;
    private String strikerId;
    private String nonStrikerId;
    private String bowlerId;
    private int totalRuns;
    private double overs;
    private int noOfWickets;

}