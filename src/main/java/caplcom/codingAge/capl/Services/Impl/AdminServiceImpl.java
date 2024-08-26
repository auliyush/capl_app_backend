package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.AdminUser;
import caplcom.codingAge.capl.Models.request.CreateRequests.UserRequest;
import caplcom.codingAge.capl.Repositories.AdminUserRepository;
import caplcom.codingAge.capl.Services.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public AdminUser createAdmin(UserRequest userRequest) {
        AdminUser adminUser = new AdminUser();
        adminUser.setUserName(userRequest.getUserName());
        adminUser.setUserPhone(userRequest.getUserPhone());
        adminUser.setUserEmail(userRequest.getUserEmail());
        adminUser.setUserPassword(userRequest.getUserPassword());
        return adminUserRepository.save(adminUser);
    }

    @Override
    public AdminUser getAdminUserByUserId(String adminId) {
        AdminUser adminUser = adminUserRepository.findByAdminId(adminId);
        if(adminUser != null){
            return adminUser;
        }else {
            return null;
        }
    }
}
