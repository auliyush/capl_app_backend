package caplcom.codingAge.capl.Services;


import caplcom.codingAge.capl.Models.User;
import caplcom.codingAge.capl.Models.request.CreateRequests.UserRequest;

import java.util.List;

public interface UserService {
    User signUp(UserRequest userRequest);
    boolean signIn(String userPhone, String userPassword);
    List<User> getListOfUsers();
    User getUserByUserId(String userId);
    User saveUpdates(User user);
}
