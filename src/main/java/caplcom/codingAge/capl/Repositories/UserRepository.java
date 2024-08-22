package caplcom.codingAge.capl.Repositories;


import caplcom.codingAge.capl.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserPhone(String userPhone);
}
