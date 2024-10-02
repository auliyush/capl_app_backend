package caplcom.codingAge.capl.Models.request.CreateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AddPlayerRequest {
   private String teamId;
   private List<String> players;
   private String creatorId;
   private Integer jerseyNumber;
}
