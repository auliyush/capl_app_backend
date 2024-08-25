package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.Admin;
import caplcom.codingAge.capl.Models.request.CreateRequests.UserRequest;
import caplcom.codingAge.capl.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public Admin signUp(@RequestBody UserRequest userRequest){
        return adminService.createAdmin(userRequest);
    }
}
