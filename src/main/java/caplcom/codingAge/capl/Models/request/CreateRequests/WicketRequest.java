package caplcom.codingAge.capl.Models.request.CreateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WicketRequest {

    private String teamId;
    private String scoreBoardId;
    private String batterId;
    private String bowlerId;
    private String fielderId;
    private String wicketDescription;

}
