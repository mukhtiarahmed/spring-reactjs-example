package com.tenhawks.auth.repository;

import com.tenhawks.auth.domain.AccessToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessTokenRepository extends MongoRepository<AccessToken, String> {


    AccessToken findByTokenId(String tokenId);

    AccessToken findByAuthenticationId(String authenticationId);

    AccessToken findByRefreshToken(String refreshToken);

    List<AccessToken> findByClientId(String clientId);

    List<AccessToken>  findByUsernameAndClientId(String username, String clientId);
}
