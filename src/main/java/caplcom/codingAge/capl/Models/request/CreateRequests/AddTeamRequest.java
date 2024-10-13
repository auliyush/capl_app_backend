package caplcom.codingAge.capl.Models.request.CreateRequests;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddTeamRequest {
    private String tournamentId;
    private List<String> teamsId;
    private String tournamentCreatorId;
}
