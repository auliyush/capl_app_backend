package caplcom.codingAge.capl.Models.request.CreateRequests;

import caplcom.codingAge.capl.Models.Stats;
import caplcom.codingAge.capl.Models.Tournament;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeasonDetailRequest {
    private String seasonYear;
    private Tournament tournament;
    private Stats stats;

}
