package caplcom.codingAge.capl.Models.request.UpdateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdatePlayer {
    private String playerId;
    private String playerProfilePhotoUrl;
    private String playerName;
    private String playerNickName;
    private String playerPhone;
    private String playerEmail;
    private String playerPassword;
    private String playerDob;
    private String playerAddress;
    private String playerType;
    private String playerSubType;
}
