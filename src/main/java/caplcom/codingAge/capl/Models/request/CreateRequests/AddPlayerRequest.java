package caplcom.codingAge.capl.Models.request.CreateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddPlayerRequest {
   private String teamId;
   private String playerId;
   private String creatorId;
   private Integer jerseyNumber;
}
