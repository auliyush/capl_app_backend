package caplcom.codingAge.capl.Repositories;
import caplcom.codingAge.capl.Models.AdminUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends MongoRepository<AdminUser, String> {
    AdminUser findByAdminId(String adminId);

    AdminUser findByAdminPhone(String phoneNumber);

    AdminUser findByAdminEmail(String userEmail);
}