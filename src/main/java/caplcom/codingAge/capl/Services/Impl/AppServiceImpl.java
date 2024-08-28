package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Exception.ApplicationException;
import caplcom.codingAge.capl.Models.AdminUser;
import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.Response.LoginResponse;
import caplcom.codingAge.capl.Models.User;
import caplcom.codingAge.capl.Models.request.CreateRequests.PlayerRequest;
import caplcom.codingAge.capl.Models.request.CreateRequests.SignUpRequest;
import caplcom.codingAge.capl.Models.request.CreateRequests.UserRequest;
import caplcom.codingAge.capl.Services.AdminUserService;
import caplcom.codingAge.capl.Services.AppService;
import caplcom.codingAge.capl.Services.PlayerService;
import caplcom.codingAge.capl.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private UserService userService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private AdminUserService adminUserService;
    @Override
    public LoginResponse login(String phoneNumber, String password) {
        User user = userService.getByPhoneNumber(phoneNumber);
        if(user != null){
            if(user.getUserPassword().equals(password)){
                return new LoginResponse(user.getUserId(), "USER");
            }else {
                throw new ApplicationException("mobile Number or Password Not Matched");
            }
        }
        Player player = playerService.getByPhoneNumber(phoneNumber);
        if(player != null){
            if(player.getPlayerPassword().equals(password)){
                return new LoginResponse(player.getPlayerId(), "PLAYER");
            }else {
                throw new ApplicationException("mobile Number or Password Not Matched");
            }
        }
        AdminUser adminUser = adminUserService.getAdminByPhoneNumber(phoneNumber);
        if(adminUser != null){
            if(adminUser.getAdminPassword().equals(password)){
                return new LoginResponse(adminUser.getAdminId(), "ADMIN");
            }else {
                throw new ApplicationException("mobile Number or Password Not Matched");
            }
        }
        return null;
    }

    @Override
    public boolean signUp(SignUpRequest signUpRequest) {
        if(userService.getByPhoneNumber(signUpRequest.getUserPhone()) == null &&
                userService.getByEmail(signUpRequest.getUserEmail()) == null &&
                playerService.getByPhoneNumber(signUpRequest.getUserPhone()) == null &&
                playerService.getByEmail(signUpRequest.getUserEmail()) == null &&
                adminUserService.getAdminByPhoneNumber(signUpRequest.getUserPhone()) == null &&
                adminUserService.getAdminByEmail(signUpRequest.getUserEmail()) == null){
            if(signUpRequest.getUserRole().equalsIgnoreCase("USER")){
                UserRequest userRequest = new UserRequest(
                        signUpRequest.getUserName(), signUpRequest.getUserPhone(),
                        signUpRequest.getUserEmail(), signUpRequest.getUserPassword()
                );
                userService.createUser(userRequest);
                return true;
            } else if (signUpRequest.getUserRole().equalsIgnoreCase("PLAYER")) {
                PlayerRequest playerRequest = new PlayerRequest(
                        signUpRequest.getUserName(), signUpRequest.getUserPhone(),
                        signUpRequest.getUserEmail(), signUpRequest.getUserPassword());
                playerService.createPlayer(playerRequest);
                return true;
            }else if (signUpRequest.getUserRole().equalsIgnoreCase("ADMIN")){
                UserRequest userRequest = new UserRequest(
                        signUpRequest.getUserName(), signUpRequest.getUserPhone(),
                        signUpRequest.getUserEmail(), signUpRequest.getUserPassword());
                adminUserService.createAdmin(userRequest);
                return true;
            }
        }
        throw new ApplicationException("Mobile Number or E-Mail already Exists");
    }
}
