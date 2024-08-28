package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Base.ApiResponse;
import caplcom.codingAge.capl.Models.AdminUser;
import caplcom.codingAge.capl.Services.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;
//    @PostMapping("/create")
//    public AdminUser createAdmin(@RequestBody UserRequest userRequest){
//        return adminUserService.createAdmin(userRequest);
//    }
    @GetMapping("/byId")
    public ApiResponse<AdminUser> getAdminById(@RequestParam String adminId){
        return new ApiResponse<>(adminUserService.getAdminUserById(adminId), HttpStatus.OK);
    }
}
// this is checked 28/08/2024  12:20