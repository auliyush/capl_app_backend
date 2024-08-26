package caplcom.codingAge.capl.Models.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private String loggedId;
    private String userRole;
}
