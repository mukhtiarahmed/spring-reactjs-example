package com.tenhawks.auth.repository;


import com.tenhawks.auth.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Mukhtiar Ahmed
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {


    User findByUserName(String userName);

    User findByEmailAddress(String email);
}
