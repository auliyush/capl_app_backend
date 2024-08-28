package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Base.ApiResponse;
import caplcom.codingAge.capl.Models.Response.LoginResponse;
import caplcom.codingAge.capl.Models.request.CreateRequests.SignUpRequest;
import caplcom.codingAge.capl.Services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*")
public class AppController {

    @Autowired
    private AppService appService;

    @PostMapping("/signUp")
    public ApiResponse<Boolean> signUp(@RequestBody SignUpRequest signUpRequest){
        return new ApiResponse<>(appService.signUp(signUpRequest), HttpStatus.OK);
    }
    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestParam String phoneNumber, String password){
        return new ApiResponse<>(appService.login(phoneNumber,password), HttpStatus.OK);
    }
}
// this is checked 28/08/2024  12:20
