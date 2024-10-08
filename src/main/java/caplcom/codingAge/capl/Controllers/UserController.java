package caplcom.codingAge.capl.Controllers;


import caplcom.codingAge.capl.Models.User;
import caplcom.codingAge.capl.Models.request.CreateRequests.UserRequest;
import caplcom.codingAge.capl.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capl/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser/ById")
    public User getUserByUserId(@RequestParam String userId){
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/listOf/User")
    public List<User> getListOfUsers(){
        return userService.getListOfUsers();
    }
}
