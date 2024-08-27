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
        adminUser.setAdminName(userRequest.getUserName());
        adminUser.setAdminPhone(userRequest.getUserPhone());
        adminUser.setAdminEmail(userRequest.getUserEmail());
        adminUser.setAdminPassword(userRequest.getUserPassword());
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

    @Override
    public AdminUser getAdminByPhoneNumber(String phoneNumber) {
        return adminUserRepository.findByAdminPhone(phoneNumber);
    }

    @Override
    public AdminUser getAdminByEmail(String userEmail) {
        return adminUserRepository.findByAdminEmail(userEmail);
    }
}
