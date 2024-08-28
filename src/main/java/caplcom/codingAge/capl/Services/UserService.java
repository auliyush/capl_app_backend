package caplcom.codingAge.capl.Services;


import caplcom.codingAge.capl.Models.User;
import caplcom.codingAge.capl.Models.request.CreateRequests.UserRequest;

import java.util.List;

public interface UserService {
    User createUser(UserRequest userRequest);

    List<User> getListOfUsers();

    User getUserByUserId(String userId);

    User getByEmail(String userEmail);

    User getByPhoneNumber(String phoneNumber);
}
