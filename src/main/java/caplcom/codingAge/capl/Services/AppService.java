package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Response.LoginResponse;
import caplcom.codingAge.capl.Models.User;
import caplcom.codingAge.capl.Models.request.CreateRequests.SignUpRequest;
import caplcom.codingAge.capl.Models.request.CreateRequests.UserRequest;

public interface AppService {
    boolean signUp(SignUpRequest signUpRequest);

    LoginResponse login(String phoneNumber, String password);

}
