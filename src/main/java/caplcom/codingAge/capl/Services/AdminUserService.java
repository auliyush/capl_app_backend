package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.AdminUser;
import caplcom.codingAge.capl.Models.request.CreateRequests.UserRequest;

public interface AdminUserService {
    AdminUser createAdmin(UserRequest userRequest);

    AdminUser getAdminUserByUserId(String adminId);

    AdminUser getByPhoneNumber(String phoneNumber);

    AdminUser getByEmail(String userEmail);
}
