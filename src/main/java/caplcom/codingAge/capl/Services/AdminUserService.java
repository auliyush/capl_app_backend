package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.AdminUser;
import caplcom.codingAge.capl.Models.request.CreateRequests.UserRequest;

public interface AdminUserService {
    AdminUser createAdmin(UserRequest userRequest);

    AdminUser getAdminUserById(String adminId);

    AdminUser getAdminByPhoneNumber(String phoneNumber);

    AdminUser getAdminByEmail(String userEmail);
}
