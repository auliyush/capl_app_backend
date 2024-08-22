package caplcom.codingAge.capl.Models.request.UpdateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateTeamRequest {
    private String teamId;
    private String creatorId;
    private String teamName;
    private String teamNickName;
    private String teamProfilePhotoUrl;
    private String teamCaptainId;
    private String teamCoachName;
}
