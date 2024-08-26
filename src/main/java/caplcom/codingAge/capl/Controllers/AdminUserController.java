package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.AdminUser;
import caplcom.codingAge.capl.Models.request.CreateRequests.UserRequest;
import caplcom.codingAge.capl.Services.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/create")
    public AdminUser createAdmin(@RequestBody UserRequest userRequest){
        return adminUserService.createAdmin(userRequest);
    }

    @GetMapping("/byId")
    public  AdminUser getAdminById(@RequestParam String adminId){
        return adminUserService.getAdminUserByUserId(adminId);
    }
}
// this is checked 25/08/2024