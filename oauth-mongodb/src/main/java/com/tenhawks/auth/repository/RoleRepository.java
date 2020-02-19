package com.tenhawks.auth.repository;


import com.tenhawks.auth.domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Mukhtiar
 */
@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

  /**
   *
   * @param roleName
   * @return
   */
  Role findByRoleName(String roleName);

}
