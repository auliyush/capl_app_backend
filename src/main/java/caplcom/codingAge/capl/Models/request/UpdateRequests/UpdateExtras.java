package caplcom.codingAge.capl.Models.request.UpdateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateExtras {
    private String id;
    private String teamId;
    private String wideRun;
    private String legByRun;
    private String noBallRun;
}
