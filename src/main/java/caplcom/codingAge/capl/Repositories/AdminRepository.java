package caplcom.codingAge.capl.Repositories;

import caplcom.codingAge.capl.Models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository <Admin, String> {

}
