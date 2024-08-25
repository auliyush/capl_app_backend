package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Admin;
import caplcom.codingAge.capl.Models.request.CreateRequests.UserRequest;

public interface AdminService {
    Admin createAdmin(UserRequest userRequest);
}
