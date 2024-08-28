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
    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setUserEmail(userRequest.getUserEmail());
        user.setUserPhone(userRequest.getUserPhone());
        user.setUserPassword(userRequest.getUserPassword());
        return userRepository.save(user);
    }

    public User getByEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    @Override
    public User getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public User getByPhoneNumber(String phoneNumber) {
        return userRepository.findByUserPhone(phoneNumber);
    }

    @Override
    public List<User> getListOfUsers() {
        return userRepository.findAll();
    }

}
