package caplcom.codingAge.capl.Models.request.CreateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ScoreBoardRequest {

    private String teamId;
    private int totalRuns;
    private double overs;
    private int noOfWickets;

}