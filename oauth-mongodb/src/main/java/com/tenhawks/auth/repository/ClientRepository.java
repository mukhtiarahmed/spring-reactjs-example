package com.tenhawks.auth.repository;

import com.tenhawks.auth.domain.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Mukhtiar on 5/23/2018.
 */
public interface ClientRepository extends MongoRepository<Client, String> {


    Client findByClientId(String clientId);

}
