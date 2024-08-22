package caplcom.codingAge.capl.Services.Impl;
import caplcom.codingAge.capl.Models.User;
import caplcom.codingAge.capl.Models.request.CreateRequests.UserRequest;
import caplcom.codingAge.capl.Repositories.UserRepository;
import caplcom.codingAge.capl.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User signUp(UserRequest userRequest) {
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setUserEmail(userRequest.getUserEmail());
        user.setUserPhone(userRequest.getUserPhone());
        user.setUserPassword(userRequest.getUserPassword());
        return userRepository.save(user);
    }

    @Override
    public boolean signIn(String userPhone, String userPassword) {
        User user = userRepository.findByUserPhone(userPhone);
        if(user != null){
            return user.getUserPassword().equals(userPassword);
        }
        return false;
    }

    @Override
    public User getUserByUserId(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getListOfUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUpdates(User user) {
        return userRepository.save(user);
    }
}
