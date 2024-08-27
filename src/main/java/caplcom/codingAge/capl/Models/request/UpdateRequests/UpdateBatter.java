package caplcom.codingAge.capl.Models.request.UpdateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateBatter {
    private String scoreBoardId;
    private String previousBatterId;
    private String newBatterId;
    private Integer newBatterJerseyNumber;
}
