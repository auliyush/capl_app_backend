package caplcom.codingAge.capl.Models.request.UpdateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateBowler {
    private String scoreBoardId;
    private String newBowlerId;
    private Integer newBowlerJerseyNumber;
}
