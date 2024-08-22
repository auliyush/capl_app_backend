package caplcom.codingAge.capl.Models.request.CreateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TournamentRequest {
    private String tournamentName;
    private String seasonYear;
    private String creatorId;
    private Date tournamentStartDate;
    private Date tournamentEndDate;
    private String stadiumName;
    private String stadiumAddress;

}