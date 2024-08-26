package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.Response.LoginResponse;
import caplcom.codingAge.capl.Models.User;
import caplcom.codingAge.capl.Models.request.CreateRequests.SignUpRequest;
import caplcom.codingAge.capl.Models.request.CreateRequests.UserRequest;
import caplcom.codingAge.capl.Services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/")
public class AppController {

    @Autowired
    private AppService appService;
    @PostMapping("/login")
    public LoginResponse login(@RequestParam String phoneNumber, String password){
        return appService.login(phoneNumber,password);
    }
    @PostMapping("/signUp")
    public boolean signUp(@RequestBody SignUpRequest signUpRequest){
        return appService.signUp(signUpRequest);
    }
}
