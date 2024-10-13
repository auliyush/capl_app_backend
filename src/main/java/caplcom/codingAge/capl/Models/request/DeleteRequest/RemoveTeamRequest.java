package caplcom.codingAge.capl.Models.request.DeleteRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RemoveTeamRequest {
    private String tournamentId;
    private List<String> teamsId;
    private String tournamentCreatorId;
}
