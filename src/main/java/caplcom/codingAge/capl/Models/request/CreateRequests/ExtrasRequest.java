package caplcom.codingAge.capl.Models.request.CreateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExtrasRequest {
    private String matchId;
    private String teamId;
    private String wideRun;
    private String legByRun;
    private String noBallRun;
}
