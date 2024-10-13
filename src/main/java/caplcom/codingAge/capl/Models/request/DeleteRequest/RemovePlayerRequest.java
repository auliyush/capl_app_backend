package caplcom.codingAge.capl.Models.request.DeleteRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RemovePlayerRequest {
    private String teamId;
    private List<String> playersId;
    private String creatorId;
}
