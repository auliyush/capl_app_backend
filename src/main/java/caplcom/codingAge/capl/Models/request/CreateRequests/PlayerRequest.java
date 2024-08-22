package caplcom.codingAge.capl.Models.request.CreateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlayerRequest {
    private String playerName;
    private String playerPhone;
    private String playerEmail;
    private String playerPassword;
    private String playerDob;
    private String playerAddress;
    private String PlayerType;
}
